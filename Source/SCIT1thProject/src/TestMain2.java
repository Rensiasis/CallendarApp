import Client.MainApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TestMain2 extends Application{
	public static Stage primaryStage;
	private AnchorPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			MainApp.primaryStage = primaryStage;
			rootLayout = (AnchorPane) FXMLLoader.load(getClass().getResource("/View/HouseHold.fxml"));
			Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("けちでも大丈夫(짠돌이라도 괜찮아)");
			primaryStage.setWidth(800);
			primaryStage.setHeight(700);
			
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
