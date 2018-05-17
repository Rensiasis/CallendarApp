package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;

public class MainApp extends Application {
	public static Stage primaryStage;
	private AnchorPane rootLayout;
	public static Alert timeAlert;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			MainApp.primaryStage = primaryStage;
			rootLayout = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
			rootLayout.setBackground(new Background(new BackgroundImage(new Image("/Image/backimg.jpg"),null,null,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
			Scene scene = new Scene(rootLayout);
	
			primaryStage.setTitle("けちでも大丈夫(짠돌이라도 괜찮아)");
			primaryStage.getIcons().add(new Image("/Image/ICON.png"));
			primaryStage.setWidth(600);
			primaryStage.setHeight(450);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
