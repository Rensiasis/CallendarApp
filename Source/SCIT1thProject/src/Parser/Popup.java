package Parser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Popup extends Application {
	//팝업창 띄워주는 클래스
	
	private String popupText;

	public Popup(String popupText) {
		super();
		this.popupText = popupText;
	}

	public Popup() {
		super();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle(popupText);
		primaryStage.show();

	}

}
