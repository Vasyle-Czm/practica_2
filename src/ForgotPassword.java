import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ForgotPassword {
    public Pane root = new Pane();

    public ForgotPassword(){
        root.setMinHeight(400);
        root.setMinWidth(600);

        Label l1 = new Label("Resetarea parolei");
        l1.setLayoutX(148);
        l1.setLayoutY(74);
        l1.setFont(new Font(40));
        TextField email = new TextField();
        email.setPromptText("Email");
        email.setLayoutX(226);
        email.setLayoutY(200);
        Button confirm = new Button("Confirm");
        confirm.setLayoutX(271);
        confirm.setLayoutY(233);
        Button logare = new Button("Logare");
        logare.setOnAction(e -> {
            Stage stage = (Stage) logare.getScene().getWindow();
            Login l = new Login();
            stage.setScene(new Scene(l.root));
        });
        logare.setLayoutX(14);
        logare.setLayoutY(14);

        root.getChildren().addAll(l1,email,confirm,logare);
    }
}
