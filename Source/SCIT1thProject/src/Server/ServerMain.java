package Server;

import java.io.BufferedReader;
import java.io.IOException;
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
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
				System.out.println("ok");
				writer.print(reader.readLine());
				System.out.println();
				writer.flush();
				socket.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				serverSocket.close();
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}