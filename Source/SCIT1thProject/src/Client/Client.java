package Client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import VO.SocketDB;

public class Client {
	public static Object summit(SocketDB socketDB) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Object result=null;
		try {
			socket = new Socket("localhost", 7777);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);
			ois = new ObjectInputStream(bis);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(socketDB);
			result=ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				ois.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
