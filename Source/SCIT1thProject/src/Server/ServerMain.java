package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Parser.EventDayParser;
import Parser.WeatherPlanetParser;
import VO.EventDay;
import VO.Weather;

public class ServerMain {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while(true) {
            Socket socket = serverSocket.accept();
            BufferedReader si=new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter so= new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

            if(si.readLine()=="A"){
                so.println(getDirContent());

            } else {
                so.println(si.readLine());
            }
             so.flush(); si.close(); so.close(); socket.close();
            }
        } catch(Exception e) {}

    }
    private static String getDirContent() {
        File dir=new File("C:/");
        String files[]=dir.list();
        List<String> list=Arrays.asList(files);
        return list.toString();
    }
}
