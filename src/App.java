import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.*;

// https://www.youtube.com/watch?v=TVLq9iSpuMs

public class App extends Application{
    public static Parent register,login;
    @Override
    public void start(Stage primaryStage) throws Exception {
        login = FXMLLoader.load(getClass().getResource("Interface\\login.fxml"));
        register = FXMLLoader.load(getClass().getResource("Interface\\register.fxml"));

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(login));
        primaryStage.show();
        
    }

    public static void main(String[] args) throws Exception,FileNotFoundException {
        launch(args);
    }
}
