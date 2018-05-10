package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainApp extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;

	// Ŭ���̾�Ʈ ���� �޼ҵ�
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("��ġ���� �����Һ� ver0.1");

		initRootLayout();

	}
	
	// ��Ʈ ���̾ƿ� �ʱ�ȭ
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			Scene scene=new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ���� �������� ��ȯ
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
