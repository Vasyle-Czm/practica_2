import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Register {
    public Pane root;

    public Register(){
        root = new Pane();
        root.setMinWidth(600);
        root.setMinHeight(400);
        root.setCacheShape(false);
        root.setCenterShape(false);
        root.setScaleShape(false);

        Label creareCont = new Label("Creare cont");
        creareCont.setLayoutX(180);
        creareCont.setLayoutY(28);
        creareCont.setFont(new Font(47));
        TextField email = new TextField();
        TextField userName = new TextField();
        TextField nume = new TextField();
        TextField prenume = new TextField();
        email.setPromptText("Email");
        userName.setPromptText("Numele de utilizator");
        nume.setPromptText("Nume");
        prenume.setPromptText("Prenume");
        email.setLayoutX(233);
        userName.setLayoutX(233);
        nume.setLayoutX(233);
        prenume.setLayoutX(233);
        email.setLayoutY(100);
        userName.setLayoutY(133);
        nume.setLayoutY(168);
        prenume.setLayoutY(203);
        PasswordField password = new PasswordField();
        password.setLayoutX(233);
        password.setLayoutY(237);
        password.setPromptText("Parola");
        Button register = new Button("Register");
        register.setOnAction(e ->{
           Stage stage = (Stage) register.getScene().getWindow();
           stage.show();
        });
        register.setLayoutX(278);
        register.setLayoutY(330);
        register.setMnemonicParsing(false);
        Button toLoginPage = new Button("Logare");
        toLoginPage.setOnAction(e ->{
            Stage stage = (Stage) toLoginPage.getScene().getWindow();
            Login l = new Login();
            stage.setScene(new Scene(l.root));
        });
        toLoginPage.setLayoutX(14);
        toLoginPage.setLayoutY(14);
        toLoginPage.setMnemonicParsing(false);
        toLoginPage.setCursor(Cursor.HAND);
        ChoiceBox<String> subdiviziune = new ChoiceBox<>();
        subdiviziune.getItems().add("Subdiviziune 1");
        subdiviziune.setLayoutX(233);
        subdiviziune.setLayoutY(274);
        subdiviziune.setPrefWidth(150);
        Label errorMessage1 = new Label("Utilizatorul deja există");
        errorMessage1.setTextFill(Color.TRANSPARENT);
        errorMessage1.setLayoutX(249);
        errorMessage1.setLayoutY(308);
        Label errorMessage2 = new Label("Toate câmpurile trebuie să fie pline !");
        errorMessage2.setTextFill(Color.TRANSPARENT);
        errorMessage2.setLayoutX(210);
        errorMessage2.setLayoutY(306);
        Label successMessage = new Label("Cont creat cu succes");
        successMessage.setLayoutX(253);
        successMessage.setLayoutY(306);
        successMessage.setTextFill(Color.TRANSPARENT);
        
        root.getChildren().addAll(creareCont,email,userName,nume,prenume,password,register,toLoginPage,subdiviziune,errorMessage1,errorMessage2,successMessage);
    }
}