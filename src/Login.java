import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
    public VBox root;
    Label logare;
    AnchorPane aPane1,aPane2,aPane3;


    public Login(){
        root = new VBox();
        root.setMaxHeight(400);
        root.setMinWidth(600);
        root.setAlignment(Pos.TOP_CENTER);
        
        
        
        aPane1 = new AnchorPane();
        aPane1.setPrefHeight(200);
        aPane1.setPrefWidth(200);
        logare = new Label("Logare");
        logare.setLayoutX(197);
        logare.setLayoutY(33);
        logare.setFont(Font.font(68));
        logare.setPadding(new Insets(5, 5, 5, 5));


        aPane2 = new AnchorPane();
        aPane2.setPrefHeight(200);
        aPane2.setPrefWidth(200);        
        TextField login = new TextField();
        login.setPromptText("Email sau user name");
        login.setLayoutX(226);
        login.setLayoutY(25);
        login.setPadding(new Insets(5,5,5,5));
        PasswordField password = new PasswordField();
        password.setPromptText("Parola");
        password.setLayoutX(226);
        password.setLayoutY(60);
        password.setPadding(new Insets(5,5,5,5));
        Label loginMessage = new Label("Parola sau login gresit");
        loginMessage.setLayoutX(234);
        loginMessage.setLayoutY(91);
        loginMessage.setTextFill(Color.TRANSPARENT);
        loginMessage.setPadding(new Insets(5,5,5,5));
        Label activtionMessage = new Label("Contul nu e activat, adresați-vă la un manager !");
        activtionMessage.setLayoutX(186);
        activtionMessage.setLayoutY(96);
        activtionMessage.setTextFill(Color.TRANSPARENT);
        
        
        aPane3 = new AnchorPane();
        aPane3.setPrefHeight(200);
        aPane3.setPrefWidth(200);
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            loginMessage.setTextFill(Color.TRANSPARENT);
            if(login.getText().equals("manager") && password.getText().equals("1")){
                Stage stage = (Stage) loginButton.getScene().getWindow();
                ManagerApp o = new ManagerApp();
                stage.setScene(new Scene(o.root));
            }
            else{
                loginMessage.setTextFill(Color.RED);
            }
        });
        loginButton.setLayoutX(273);
        loginButton.setLayoutY(49);
        loginButton.setCursor(Cursor.HAND);
        loginButton.setFont(new Font(14));
        loginButton.setPadding(new Insets(5,5,5,5));
        Button forgotPasswordButton = new Button("Ai uitat parola ?");
        forgotPasswordButton.setOnAction(e -> {
            Stage stage = (Stage) forgotPasswordButton.getScene().getWindow();
            ForgotPassword o = new ForgotPassword();
            stage.setScene(new Scene(o.root));
        });
        forgotPasswordButton.setLayoutX(225);
        forgotPasswordButton.setLayoutY(4);
        forgotPasswordButton.setTextFill(Color.BLUE);
        forgotPasswordButton.setTextOverrun(OverrunStyle.CLIP);
        forgotPasswordButton.setCursor(Cursor.HAND);
        forgotPasswordButton.setBackground(Background.EMPTY);
        forgotPasswordButton.setPadding(new Insets(5,5,5,5));
        forgotPasswordButton.setMnemonicParsing(false);
        Button newAccountButton = new Button("Crează cont nou");
        newAccountButton.setOnAction(e -> {
            Stage stage = (Stage)newAccountButton.getScene().getWindow();
            Register o = new Register();
            stage.setScene(new Scene(o.root));
        });
        newAccountButton.setLayoutX(225);
        newAccountButton.setLayoutY(-17);
        newAccountButton.setMnemonicParsing(false);
        newAccountButton.setTextFill(Color.BLUE);
        newAccountButton.setTextOverrun(OverrunStyle.CLIP);
        newAccountButton.setBackground(Background.EMPTY);
        newAccountButton.setCursor(Cursor.HAND);
        newAccountButton.setPadding(new Insets(5,5,5,5));



        aPane1.getChildren().addAll(logare);
        aPane2.getChildren().addAll(login,password,loginMessage,activtionMessage);
        aPane3.getChildren().addAll(loginButton,forgotPasswordButton,newAccountButton);
        root.getChildren().addAll(aPane1,aPane2,aPane3);
    }
}