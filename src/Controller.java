import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.*;

public class Controller {
    @FXML
    private TextField loginRegister,passwordRegister,loginLogin,passwordLogin;
    @FXML
    private Label registerMessage,registerMessage1,loginMessage;
    
    protected static ArrayList<String> passwordBD = new ArrayList<>();
    protected static ArrayList<String> loginBD = new ArrayList<>();


    public void login(ActionEvent event) throws IOException{
        boolean k = false;
        
        
        
        if(loginLogin.getText().equals("master") && passwordLogin.getText().equals("1")){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\managerApp.fxml"))));
        }
        else{
            for(int i=0;i<loginBD.size();i++){
                if(loginBD.get(i).equals(loginLogin.getText()) && passwordBD.get(i).equals(passwordLogin.getText())){
                    k = true;
                    break;
                }
            }
            if(k == false){
                loginMessage.setStyle("-fx-text-fill: red;");
            }
            else{
                Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\app.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setResizable(true);
                stage.setScene(new Scene(t1));
            }
        }
    }
    
    public void forgotPassword(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\fgpassword.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void createNewAccount(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\register.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void loginPage(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\login.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void register(ActionEvent event) throws IOException{
        String l = loginRegister.getText();
        String p = passwordRegister.getText();
        File file = new File("src\\Database\\BD.txt");
        FileWriter fout = new FileWriter(file,true);

        int k = 0;
        for(int i = 0; i < loginBD.size(); i++){
            if(loginBD.get(i).equals(l)){
                k++;
            }
        }

        if(k == 0){
            registerMessage1.setStyle("-fx-text-fill: green;");
            registerMessage.setStyle("-fx-text-fill: transparent;");
            
            loginBD.add(l);
            passwordBD.add(p);
            fout.write("\n"+l+" "+p);
        }
        else{
            registerMessage.setStyle("-fx-text-fill: red;");
            registerMessage1.setStyle("-fx-text-fill: transparent;");
            System.out.println("EROARE LOGINUL DEJA EXISTA");
        }
        k = 0;
        fout.close();
    }

    public void test(){
        System.out.println("DEBUG");
    }



}
