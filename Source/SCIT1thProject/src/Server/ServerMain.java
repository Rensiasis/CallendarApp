package Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import VO.SocketDB;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			serverSocket = new ServerSocket(7777);
			socket = serverSocket.accept();
			System.out.println("Server start");
			while (true) {
				is = socket.getInputStream();
				os = socket.getOutputStream();
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(os);
				ois = new ObjectInputStream(bis);
				oos = new ObjectOutputStream(bos);
				SocketDB msg = (SocketDB) ois.readObject();
				System.out.println("Client access");
				Object result = msg.update();
				oos.writeObject(result);
				System.out.println("DB update success");
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				serverSocket.close();
				socket.close();
				ois.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}