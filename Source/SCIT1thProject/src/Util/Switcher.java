package Util;

import javafx.application.Application;
import javafx.stage.Stage;

public class Switcher {
	
	//화면전환 클래스
	
	public static void switchWindow(Stage window, Application app) {
	    try {
	        app.start(window);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
