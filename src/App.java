import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.fxml.*;

// https://www.youtube.com/watch?v=TVLq9iSpuMs

public class App extends Application{
    public static Parent register,login;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l1 = new Label("Enter the login:");
        TextField t1 = new TextField();
        Label l2 = new Label("Intrdu parola:");
        PasswordField t2 = new PasswordField();

        VBox vb = new VBox(10);
        vb.getChildren().addAll(l1,t1,l2,t2);

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
