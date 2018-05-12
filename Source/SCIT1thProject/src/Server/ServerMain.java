package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			while (true) {
				serverSocket = new ServerSocket(7777);
				Socket socket = serverSocket.accept();
				System.out.println("connect HAM");
				InputStream inputstream=socket.getInputStream();
				byte[] buf=new byte[1024];
				inputstream.read(buf);
				String inputMsg=new String(buf).trim();
				writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
				System.out.println("ok");
				System.out.println(inputMsg);
				writer.write(inputMsg);
				writer.flush();
				inputstream.close();
				socket.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				serverSocket.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}