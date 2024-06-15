import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.*;

// https://www.youtube.com/watch?v=TVLq9iSpuMs

public class App extends Application{
    public static Parent register,login;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner in = new Scanner(new FileReader(new File("src\\Database\\accountsInfo.txt")));
        while(in.hasNext()){
            Controller.acc.add(new Users(in.next(),in.next(),in.next(),in.next(),in.next(),in.next(),in.next(),Integer.parseInt(in.next())));
        }
        Scanner bin = new Scanner(new FileReader(new File("src\\Database\\buget.txt")));
        Users.setBuget(bin.nextInt());
        bin.close();
        in.close();

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\login.fxml"))));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception,FileNotFoundException {
        launch(args);
    }
}
