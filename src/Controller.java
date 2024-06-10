import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;

// ListView
// https://www.youtube.com/watch?v=Pqfd4hoi5cc&list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev&index=21


public class Controller implements Initializable{
    @FXML
    private TextField loginRegister,passwordRegister,loginLogin,passwordLogin,userName,firstName,lastName;
    @FXML
    private Label registerMessage,registerMessage1,loginMessage,myLabel;
    @FXML
    private ListView<String> myListView = new ListView<>();

    protected static ArrayList<String> passwordBD = new ArrayList<>();
    protected static ArrayList<String> loginBD = new ArrayList<>();

    private ArrayList<Users> acc = new ArrayList<>();

    public void login(ActionEvent event) throws IOException{
        boolean k = false;

        if(loginLogin.getText().equals("master") && passwordLogin.getText().equals("1")){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\managerApp.fxml"))));
            // String[] users = {"user1","user2"};
            // System.out.println("myListView este null: " + (myListView == null));
            
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
        FileWriter out = new FileWriter(new File("src\\Database\\accountsInfo.txt"),true);
        acc.add(new Users(loginRegister.getText(), userName.getText(), firstName.getText(), lastName.getText(), passwordRegister.getText()));
        out.write(" \n"+ loginRegister.getText()+ " " +userName.getText()+ " " +firstName.getText()+ " " +lastName.getText()+ " " +passwordRegister.getText()+ " "+ acc.get(acc.size() - 1).getCreationDate());
        out.close();
    }

    public void test(){
        System.out.println("DEBUG");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Scanner in = new Scanner(new FileReader(new File("src\\Database\\accountsInfo.txt")));
            while(in.hasNext()){
                acc.add(new Users(in.next(),in.next(),in.next(),in.next(),in.next(),in.next()));
            }
            in.close();
            
            
            
            String[] c = {"user1","user2","user3"};
            myListView.getItems().addAll(c);
            myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                myLabel.setText(myListView.getSelectionModel().getSelectedItem());
            }
            
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
