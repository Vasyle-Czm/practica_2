import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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

        login = FXMLLoader.load(getClass().getResource("login.fxml"));
        register = FXMLLoader.load(getClass().getResource("register.fxml"));

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(login));
        primaryStage.show();

        //Controller a = new Controller(primaryStage);
    }

    public static void input() throws FileNotFoundException{
        Scanner in = new Scanner(new File("src\\BD.txt"));

        while(in.hasNextLine()){
            Controller.loginBD.add(in.next());
            Controller.passwordBD.add(in.next());
        }
        in.close();

        // System.out.println("Lista de loginuri");
        // for(String a : Controller.loginBD){
        //     System.out.println(a);
        // }
        // System.out.println("Lista de parole");
        // for(String a : Controller.passwordBD){
        //     System.out.println(a);
        // }
    }

    public static void main(String[] args) throws Exception,FileNotFoundException {
        input();
        launch(args);
    }
}
