package task.lab12;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController controller = loader.getController();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Phone Book");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

