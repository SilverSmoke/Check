package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< 079830fe4c89b7d4bc8214213a2274abdc8386c2
        Parent root = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        primaryStage.setTitle("Check");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
=======
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
>>>>>>> bed
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
