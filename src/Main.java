import Interface.app;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        app l = new app();

        stage.setScene(new Scene(l.root));
        stage.setResizable(false);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
    
}
