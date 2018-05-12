package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			Socket socket = new Socket("localhost", 7777);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
			Scanner ki = new Scanner(System.in);
			writer.write(ki.nextLine());
			writer.flush();
			System.out.println(reader.readLine());
			socket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
