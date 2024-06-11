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
import javafx.scene.paint.Color;
import javafx.scene.control.ChoiceBox;
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
    private Label registerMessage,registerMessage1,loginMessage,myLabel,infoLabel,activationMessage,notnullMessage;
    @FXML
    private ListView<String> myListView = new ListView<>();
    @FXML
    private ChoiceBox<String> selectSubdivision = new ChoiceBox<>();

    private ArrayList<Users> acc = new ArrayList<>();
    
    public void login(ActionEvent event) throws IOException{
        boolean k = false;
        int index = 0;
        activationMessage.setTextFill(Color.TRANSPARENT);
        loginMessage.setTextFill(Color.TRANSPARENT);


        if(loginLogin.getText().equals("master") && passwordLogin.getText().equals("1")){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(true);
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\managerApp.fxml"))));     
        }
        else{
            for(int i=0;i<acc.size();i++){
                if((acc.get(i).getEmail().equals(loginLogin.getText()) || acc.get(i).getUsername().equals(loginLogin.getText())) && acc.get(i).getParola().equals(passwordLogin.getText())){
                    k = true;
                    index = i;
                    break;
                }
            }
            if(k == false){
                loginMessage.setStyle("-fx-text-fill: red;");
            }
            else{
                if(acc.get(index).getActivation() == true){
                    Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\app.fxml"));
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setResizable(true);
                    stage.setScene(new Scene(t1));
                }
                else{
                    activationMessage.setTextFill(Color.RED);
                    System.out.println("CONTUL NU E ACTIVAT");
                }
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
        notnullMessage.setTextFill(Color.TRANSPARENT);

        boolean k = false;
        for(int i=0;i<acc.size();i++){
            if(acc.get(i).getEmail().equals(loginRegister.getText()) || acc.get(i).getUsername().equals(userName.getText())){
                registerMessage.setTextFill(Color.RED);
                registerMessage1.setTextFill(Color.TRANSPARENT);
                k = true;
                break;
            }
        }

        
        if(k == false){
            if(loginRegister.getText().isEmpty() || userName.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty() || passwordRegister.getText().isEmpty() || selectSubdivision.getSelectionModel().isEmpty()){
                notnullMessage.setTextFill(Color.RED);
            } 
            else{
                registerMessage.setTextFill(Color.TRANSPARENT);
                registerMessage1.setTextFill(Color.GREEN);
                FileWriter out = new FileWriter(new File("src\\Database\\accountsInfo.txt"),true);
                acc.add(new Users(loginRegister.getText(), userName.getText(), firstName.getText(), lastName.getText(), passwordRegister.getText()));
                out.write(" \n"+ loginRegister.getText()+ " " +userName.getText()+ " " +firstName.getText()+ " " +lastName.getText()+ " " +passwordRegister.getText()+ " "+ acc.get(acc.size() - 1).getCreationDate() + " " + acc.get(acc.size() - 1).getActivation());
                out.close();    
            }
        }
    }

    public void quitManager(){
        System.out.println("INCA NU FACE NIMIC");
    }

    public void newReport(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("src\\Interface\\appNewReport.fxml"))));
    }

    public void accountActivation() throws IOException{
        int index = myListView.getSelectionModel().getSelectedIndex();
        
        if(acc.get(index).getActivation() == false){
            acc.get(index).setActivation(true);
            FileWriter save = new FileWriter(new File("src\\Database\\accountsInfo.txt"));

            String activ = acc.get(index).getActivation() ? "Activat" : "Dezactivat";
            myLabel.setText(myListView.getSelectionModel().getSelectedItem() + "\n" + acc.get(index).getEmail() + "\n" +acc.get(index).getNume() + "\n" +acc.get(index).getPrenume() + "\n" + acc.get(index).getCreationDate() + "\n" + activ);

            for(int i=0;i<acc.size();i++){
                save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation());
                if(i != acc.size() - 1){
                    save.write("\n");
                }
            }
            save.close();
        }
        else
            System.out.println("CONTUL ESTE DEJA ACTIVAT");   
    
    }
    
    public void accountDezactivation() throws IOException{
        int index = myListView.getSelectionModel().getSelectedIndex();

        if(acc.get(index).getActivation() == true){
            acc.get(index).setActivation(false);
            FileWriter save = new FileWriter(new File("src\\Database\\accountsInfo.txt"));

            String activ = acc.get(index).getActivation() ? "Activat" : "Dezactivat";
            myLabel.setText(myListView.getSelectionModel().getSelectedItem() + "\n" + acc.get(index).getEmail() + "\n" +acc.get(index).getNume() + "\n" +acc.get(index).getPrenume() + "\n" + acc.get(index).getCreationDate() + "\n" + activ);

            for(int i=0;i<acc.size();i++){
                save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation());
                if(i != acc.size() - 1){
                    save.write("\n");
                }
            }

            save.close();
        }
        else
            System.out.println("CONTUL ESTE DEJA DEZACTIVAT");
    }

    public void accountDeletion() throws IOException{
        try {
            
            int index = myListView.getSelectionModel().getSelectedIndex();
    
            acc.remove(index);
    
            FileWriter save = new FileWriter(new File("src\\Database\\accountsInfo.txt"));
    
            for(int i=0;i<acc.size();i++){
                save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation());
                if(i != acc.size() - 1){
                    save.write("\n");
                }
            }
            
            String[] c = new String[acc.size()];
            for(int i=0;i<acc.size();i++){
                c[i] = acc.get(i).getUsername();
            }
    
    
            myLabel.setText(null);
            infoLabel.setText(null);
    
            myListView.getSelectionModel().clearSelection();
            myListView.getItems().setAll(c);
    
            save.close();

        }
        catch(Exception e){
            System.out.println("EROARE \n" + e);
        }
        
    }


    public void appSettings(){
        System.out.println("SETARI");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            String[] sub = {"Diviziunea 1","Diviziunea 2","Diviziunea 3"};
            selectSubdivision.getItems().addAll(sub);
            
            
            
            
            
            
            
            
            Scanner in = new Scanner(new FileReader(new File("src\\Database\\accountsInfo.txt")));
            while(in.hasNext()){
                acc.add(new Users(in.next(),in.next(),in.next(),in.next(),in.next(),in.next(),in.next()));
            }
            in.close();

            String[] c = new String[acc.size()];
            for(int i=0;i<acc.size();i++){
                c[i] = acc.get(i).getUsername();
            }
            
            myListView.getItems().addAll(c);
            myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                int index = myListView.getSelectionModel().getSelectedIndex();
                infoLabel.setText("User name: "+"\n"+"Email: "+"\n"+"Nume: "+"\n"+"Prenume:"+"\n"+ "Data crearii contului:"+"\n"+"Statutul contului:");
                String activ = acc.get(index).getActivation() ? "Activat" : "Dezactivat";
                myLabel.setText(myListView.getSelectionModel().getSelectedItem() + "\n" + acc.get(index).getEmail() + "\n" +acc.get(index).getNume() + "\n" +acc.get(index).getPrenume() + "\n" + acc.get(index).getCreationDate() + "\n" + activ);
                myLabel.setTextFill(javafx.scene.paint.Color.BLACK);
            }
            
        });
        } catch (Exception e) {
            System.out.println("EROARE" + e);
        }
    }
}
