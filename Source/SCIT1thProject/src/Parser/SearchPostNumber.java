package Parser;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import VO.Address;

public class SearchPostNumber {
	private final static String apiURL = "http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll";
	private final static String serviceKey = "%2FK6rEXdufql9pjWM3hfGNOdz0NQ2ChmJFK%2FpjLQtXibSAAnCgJdZ3Rpx0%2FLcKmOan4BTu5VowVDfy2Ik%2FJIxFA%3D%3D";
	ArrayList<Address> resultList;
	private String keyWord = null;
	private int totalCount;

	public int getTotalCount() {
		return totalCount;
	}

	public ArrayList<Address> searchAddress(String keyWord) {
		HttpURLConnection con = null;
		this.keyWord = keyWord;
		try {
			int pageNO = 1;
			URL url = new URL(apiURL + "?ServiceKey=" + serviceKey + "&countPerPage=50&currentPage=" + pageNO
					+ "&srchwrd=" + URLEncoder.encode(keyWord, "UTF-8"));
			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Accept-language", "ko");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(con.getInputStream());
			boolean flag = false;
			String nodeName;
			Node node;
			NodeList nodeList = document.getElementsByTagName("cmmMsgHeader");
			totalCount = 0;
			resultList = new ArrayList<>();
			for (node = nodeList.item(0).getFirstChild(); node != null; node = node.getNextSibling()) {
				nodeName = node.getNodeName();
				if (!flag) {
					if (nodeName.equals("successYN")) {
						if (node.getTextContent().equals("Y"))
							flag = true;
					} else if (nodeName.equals("errMsg")) {
						return null;
					}
				} else {
					if (node.getNodeName().equals("totalCount")) {
						totalCount = Integer.parseInt(node.getTextContent());
						break;
					}
				}
			}
			if (flag) {
				nodeList = document.getElementsByTagName("newAddressListAreaCdSearchAll");
				for (int i = 0; i < nodeList.getLength(); i++) {
					node = nodeList.item(i).getFirstChild();
					String postNumber = node.getTextContent();
					node = node.getNextSibling();
					String newAddress = node.getTextContent();
					node = node.getNextSibling();
					String oldAddress = node.getTextContent();
					Address address = new Address();
					address.setPostNumber(postNumber);
					address.setNewAddress(newAddress);
					address.setOldAddress(oldAddress);
					resultList.add(address);
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			con.disconnect();
		}
		return resultList;
	}

	public String getURLPerPage(int page) {
		try {
			return apiURL + "?ServiceKey=" + serviceKey + "&countPerPage=50&currentPage=" + page + "&srchwrd="
					+ URLEncoder.encode(keyWord, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
