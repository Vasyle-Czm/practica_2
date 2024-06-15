import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

// ListView
// https://www.youtube.com/watch?v=Pqfd4hoi5cc&list=PLZPZq0r_RZOM-8vJA3NQFZB7JroDcMwev&index=21


public class Controller implements Initializable{
    @FXML
    private TextField loginRegister,passwordRegister,loginLogin,passwordLogin,userName,firstName,lastName,reportName,reportPrice,buget,settingsTextFIeld1,settingsTextFIeld2,settingsTextFIeld3;
    @FXML
    private Label registerMessage,registerMessage1,loginMessage,myLabel,infoLabel,activationMessage,notnullMessage,USER,fileInputMessage,reportSuccess,reportInfo,reportInfo1,reportInfo2,appControlPanelInfo,appControlPanelInfo1,bugetLabel,appInfo,appBuget,settingsInfo,settingsInfo1,changeError,label,label1,label2;
    @FXML
    private ListView<String> myListView = new ListView<>();
    @FXML
    private ListView<String> reportsList = new ListView<>();
    @FXML
    private ListView<String> reports = new ListView<>();
    @FXML
    private ChoiceBox<String> selectSubdivision = new ChoiceBox<>();
    @FXML
    private Button newReport,changeConfirm; 
    @FXML
    private ImageView avatar = new ImageView();
    @FXML
    private ImageView imgview = new ImageView();
    @FXML
    private TextArea reportDesc;

    protected static ArrayList<Users> acc = new ArrayList<>();
    private static int userIndex;
    
    public void login(ActionEvent event) throws IOException{
        boolean k = false;
        int index = 0;
        activationMessage.setTextFill(Color.TRANSPARENT);
        loginMessage.setTextFill(Color.TRANSPARENT);


        if(loginLogin.getText().equals("master") && passwordLogin.getText().equals("1")){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(false);
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
                    userIndex = index;
                    Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\app.fxml"));
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setResizable(false);
                    stage.setScene(new Scene(t1));
                }
                else{
                    activationMessage.setTextFill(Color.RED);
                    System.out.println("CONTUL NU E ACTIVAT");
                }
            }
        }
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
                out.write(" \n"+ loginRegister.getText()+ " " +userName.getText()+ " " +firstName.getText()+ " " +lastName.getText()+ " " +passwordRegister.getText()+ " "+ acc.get(acc.size() - 1).getCreationDate() + " " + acc.get(acc.size() - 1).getActivation() + " " + "0");
                out.close();    
            }
        }
    }
    
    public void toForgotPassword(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\fgpassword.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void toCreateNewAccount(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\register.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void toLoginPage(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\login.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }

    public void backToApp(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\app.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));
    }
    public void toNewReport(ActionEvent event) throws IOException{
        Parent scene = FXMLLoader.load(getClass().getResource("Interface\\appNewReport.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(scene));
    }

    public void toAppSettings(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\appSettings.fxml"))));
    }

    @FXML
    private void toMyReports(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Interface\\appMyReports.fxml"))));        
    }

    public void quitManager(){
        System.out.println("INCA NU FACE NIMIC");
    }

    public void accountActivation() throws IOException{
        int index = myListView.getSelectionModel().getSelectedIndex();
        
        if(acc.get(index).getActivation() == false){
            acc.get(index).setActivation(true);
            FileWriter save = new FileWriter(new File("src\\Database\\accountsInfo.txt"));

            String activ = acc.get(index).getActivation() ? "Activat" : "Dezactivat";
            myLabel.setText(myListView.getSelectionModel().getSelectedItem() + "\n" + acc.get(index).getEmail() + "\n" +acc.get(index).getNume() + "\n" +acc.get(index).getPrenume() + "\n" + acc.get(index).getCreationDate() + "\n" + activ);

            for(int i=0;i<acc.size();i++){
                save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation() + " " + acc.get(i).getRaport());
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
                save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation() + " " + acc.get(i).getRaport());
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
    
            save();
            
            String[] c = new String[acc.size()];
            for(int i=0;i<acc.size();i++){
                c[i] = acc.get(i).getUsername();
            }

            myLabel.setText(null);
            infoLabel.setText(null);
            myListView.getSelectionModel().clearSelection();
            myListView.getItems().setAll(c);
        }
        catch(Exception e){}
        
    }

    @FXML
    private void setBuget(){
        try{
            Users.setBuget(Integer.parseInt(buget.getText()));
            bugetLabel.setText(buget.getText() + " €");
            FileWriter save = new FileWriter(new File("src\\Database\\buget.txt"));
            save.write(buget.getText());
            save.close();

            buget.clear();
        }
        catch(Exception e){
            System.out.println("Buget : "+e);
        }
    }

    @FXML
    private void singeFileChooser(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new ExtensionFilter("Imagini", "*.png", "*.jpg")
        );
        fc.setInitialDirectory(new File("src/Database/PozeChitante")); 
        File selectedFile = fc.showOpenDialog(stage);
    
        if (selectedFile != null) {
            try {
                String newFileName = "raport---"+acc.get(userIndex).getUsername()+"---"+acc.get(userIndex).getRaport()+".png";

                
                Path sourcePath = selectedFile.toPath();
                Path targetPath = new File("src/Database/PozeChitante/" + newFileName).toPath();
    
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                

                fileInputMessage.setText("Fisier salvat cu succes");
                fileInputMessage.setTextFill(Color.GREEN);

                

            } catch (Exception ex) {
                fileInputMessage.setText("EROARE !!! Adresativă la un manager !");
            }
        } else {
            fileInputMessage.setTextFill(Color.RED);
            fileInputMessage.setText("Niciun fisier nu a fost selectat!");
        }
    }
    
    @FXML
    private void newReport() throws IOException{
        try {
            FileWriter out = new FileWriter(new File("src\\Database\\Reports\\"+"raport---"+acc.get(userIndex).getUsername()+"---"+acc.get(userIndex).getRaport() + ".txt"));
            out.write(reportName.getText() + " " + reportPrice.getText()+ " \n" + reportDesc.getText());
            out.close();
            acc.get(userIndex).setRaport(acc.get(userIndex).getRaport() + 1);
            reportSuccess.setTextFill(Color.GREEN);


            Users.setBuget(Users.getBuget() - Integer.parseInt(reportPrice.getText()));
            FileWriter save = new FileWriter(new File("src\\Database\\buget.txt"));
            save.write(Users.getBuget() + " ");
            save.close();
        } catch (Exception e) {
            reportSuccess.setText("Eroare !!! (adresativa la un manager)");
            reportSuccess.setTextFill(Color.RED);
        }

        save();

    }

    @FXML
    private void errorClear(){
        changeError.setVisible(false);
    }

    @FXML
    private void newUsername(){
        settingsTextFIeld1.clear();
        settingsTextFIeld2.clear();
        settingsTextFIeld3.clear();
        settingsTextFIeld1.setPromptText("Username nou");
        settingsTextFIeld2.setPromptText("Parola");
        settingsTextFIeld1.setVisible(true);
        settingsTextFIeld2.setVisible(true);
        settingsTextFIeld3.setVisible(false);
        changeConfirm.setVisible(true);
        changeError.setVisible(false);

        changeConfirm.setOnAction(e -> {
            if(settingsTextFIeld2.getText().equals(acc.get(userIndex).getParola())){
                if(settingsTextFIeld1.getText().equals(acc.get(userIndex).getUsername())){
                    changeError.setTextFill(Color.RED);
                    changeError.setText("Deja aveti acest username!");
                    changeError.setVisible(true);
                }
                else{
                    boolean check = false;
                    for(int i=0;i<acc.size();i++){
                        if(acc.get(i).getUsername().equals(settingsTextFIeld1.getText())){
                            check = true;
                            break;
                        }
                    }

                    if(check == true){
                        changeError.setTextFill(Color.RED);
                        changeError.setText("Username-ul deja există!");
                        changeError.setVisible(true);
                    }
                    else{
                        try {
                            acc.get(userIndex).setUsername(settingsTextFIeld1.getText());
                            save();
                            
                            changeError.setTextFill(Color.GREEN);
                            changeError.setText("Succes!");
                            changeError.setVisible(true);
                        } catch (Exception error) {
                            changeError.setTextFill(Color.RED);
                            changeError.setText("A apărut o eroare!\n"+error);
                            changeError.setVisible(true);
                        }
                    }
                }
            }
            else{
                changeError.setTextFill(Color.RED);
                changeError.setText("Parola nu corespunde!");
                changeError.setVisible(true);
            }
        });
    
    }

    @FXML
    private void newEmail(){
        settingsTextFIeld1.clear();
        settingsTextFIeld2.clear();
        settingsTextFIeld3.clear();
        settingsTextFIeld1.setPromptText("Email nou");
        settingsTextFIeld2.setPromptText("Parola");
        settingsTextFIeld1.setVisible(true);
        settingsTextFIeld2.setVisible(true);
        settingsTextFIeld3.setVisible(false);
        changeConfirm.setVisible(true);
        changeError.setVisible(false);
        

        changeConfirm.setOnAction(e -> {
            if(acc.get(userIndex).getParola().equals(settingsTextFIeld2.getText())){
                if(acc.get(userIndex).getEmail().equals(settingsTextFIeld1.getText())){
                    changeError.setTextFill(Color.RED);
                    changeError.setText("Aveti deja acest email!");
                    changeError.setVisible(true);
                }
                else{
                    boolean check = false;
                    for(int i=0;i<acc.size();i++){
                        if(acc.get(i).getEmail().equals(settingsTextFIeld1.getText())){
                            check = true;
                            break;
                        }
                    }
                    
                    if(check == true){
                        changeError.setTextFill(Color.RED);
                        changeError.setText("Alt utilizator are\nacest email!");
                        changeError.setVisible(true);
                    }
                    else{
                        try {
                            acc.get(userIndex).setEmail(settingsTextFIeld1.getText());
                            save();

                            changeError.setTextFill(Color.GREEN);
                            changeError.setText("Succes!");
                            changeError.setVisible(true);
                        } catch (Exception error) {
                            changeError.setTextFill(Color.RED);
                            changeError.setText("A apărut o eroare!");
                            changeError.setVisible(true);
                        }
                    }
                }
            }
            else{
                changeError.setTextFill(Color.RED);
                changeError.setText("Parola nu corespunde!");
                changeError.setVisible(true);
            }
        });
    }

    @FXML
    private void newPassword(){
        settingsTextFIeld1.clear();
        settingsTextFIeld2.clear();
        settingsTextFIeld3.clear();
        settingsTextFIeld3.setPromptText("Parola veche");
        settingsTextFIeld2.setPromptText("Parola nouă");
        settingsTextFIeld3.setVisible(true);
        settingsTextFIeld2.setVisible(true);
        settingsTextFIeld1.setVisible(false);
        changeConfirm.setVisible(true);
        changeError.setVisible(false);

        changeConfirm.setOnAction(e -> {
            if(acc.get(userIndex).getParola().equals(settingsTextFIeld3.getText())){
                if(acc.get(userIndex).getParola().equals(settingsTextFIeld2.getText())){
                    changeError.setText("Nu vă puteți seta aceiași parolă!");
                    changeError.setTextFill(Color.RED);
                    changeError.setVisible(true);
                }
                else{
                    try {
                        acc.get(userIndex).setParola(settingsTextFIeld2.getText());
                        save();

                        changeError.setText("Succes!");
                        changeError.setTextFill(Color.GREEN);
                        changeError.setVisible(true);
                    } catch (Exception error) {
                        changeError.setText("A apărut o eroare!");
                        changeError.setTextFill(Color.RED);
                        changeError.setVisible(true);
                    }
                }
            }
            else{
                changeError.setText("Parola veche nu\ncorespunde!");
                changeError.setTextFill(Color.RED);
                changeError.setVisible(true);
            }
        });
    }


    private void save() throws IOException{
        FileWriter save  = new FileWriter(new File("src\\Database\\accountsInfo.txt"));
        for(int i=0;i<acc.size();i++){
            save.write(acc.get(i).getEmail()+ " " +acc.get(i).getUsername()+ " " +acc.get(i).getNume()+ " " +acc.get(i).getPrenume()+ " " +acc.get(i).getParola()+ " "+ acc.get(i).getCreationDate() + " " + acc.get(i).getActivation() + " " + acc.get(i).getRaport());
            if(i != acc.size() - 1){
                save.write("\n");
            }
        }
        save.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            appControlPanelInfo.setText("User name: "+"\n"+"Email: "+"\n"+"Nume: "+"\n"+"Prenume:"+"\n"+ "Data crearii contului:"+"\n"+"Numarul de rapoarte:");
        } catch (Exception e) {}
                
                
        try {                
            appInfo.setText(acc.get(userIndex).getUsername()+ "\n" +acc.get(userIndex).getEmail() + "\n" +acc.get(userIndex).getNume() + "\n" +acc.get(userIndex).getPrenume() + "\n" + acc.get(userIndex).getCreationDate() + "\n" + acc.get(userIndex).getRaport());
        } catch (Exception e) {}



        try {
            String[] sub = {"Consultanță în obținerea cetățeniei românești","Consultanță privind strategii","Consultanță în afaceri","Consultanță financiară","Consultanță IT","Consultanță în management","Consultanță în vânzări","Consultanță în marketing","Consultanță de brand","Servicii de consultanță în imobiliare"};
            Arrays.sort(sub);
            selectSubdivision.getItems().addAll(sub);
            
            String[] c = new String[acc.size()];
            for(int i=0;i<acc.size();i++){
                c[i] = acc.get(i).getUsername();
            }
            
            myListView.getItems().addAll(c);
            myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                try {
                    int index = myListView.getSelectionModel().getSelectedIndex();
                    infoLabel.setText("User name: "+"\n"+"Email: "+"\n"+"Nume: "+"\n"+"Prenume:"+"\n"+ "Data crearii contului:"+"\n"+"Numarul de rapoarte:"+"\n"+"Statutul contului:");
                    String activ = acc.get(index).getActivation() ? "Activat" : "Dezactivat";
                    myLabel.setText(myListView.getSelectionModel().getSelectedItem() + "\n" + acc.get(index).getEmail() + "\n" +acc.get(index).getNume() + "\n" +acc.get(index).getPrenume() + "\n" + acc.get(index).getCreationDate() + "\n" + acc.get(index).getRaport()+ "\n" + activ);
                    myLabel.setTextFill(Color.BLACK);
                    



                    
                    String[] a = new String[acc.get(index).getRaport()];
                    Scanner in;
                    
                    for(int i=0;i<acc.get(index).getRaport();i++){
                        in = new Scanner(new FileReader(new File("src\\Database\\Reports\\raport---"+acc.get(index).getUsername()+"---"+i+".txt")));
                        a[i] = "Raportul nr." + (i+1) + " - " + in.next();
                        
                        
                    }
                    
                    reports.getItems().setAll(a);
                    

                    reports.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                        @Override
                        public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                            
                            try {
                                int reportIndex = reports.getSelectionModel().getSelectedIndex();
                                Scanner in = new Scanner(new FileReader(new File("src\\Database\\Reports\\raport---"+acc.get(index).getUsername()+"---"+reportIndex+".txt")));
                                label.setText(in.next());
                                label1.setText(in.next());


                                String c = "";
                                while (in.hasNextLine()) {
                                    String line = in.nextLine(); 
                                    Scanner lineScanner = new Scanner(line); 
                                    while (lineScanner.hasNext()) {
                                        c += lineScanner.next() + " "; 
                                    }
                                    c += "\n"; 
                                    lineScanner.close(); 
                                }

                                label2.setText(c);
                                in.close();
                                // TODO: Bug on report 2 on username 1
                                // TODO: Bug on setting image

                                imgview.setImage(new Image("src\\Database\\PozeChitante\\raport---1---0.png"));
                                
                            } catch (Exception e) {
                                // TODO: handle exception
                            }    
                        }
                    });

                
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }    
        });

        USER.setText(acc.get(userIndex).getUsername());

        } catch (Exception e) {}

        

        //////////////////////////////////////////////////////////////


        try {
            String[] list = new String[acc.get(userIndex).getRaport()];
            for(int i=0;i<acc.get(userIndex).getRaport();i++){
                list[i] = "Raportul numărul "+(i+1);
            }
            reportsList.getItems().addAll(list);
    
            reportsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    try {
                        int index = reportsList.getSelectionModel().getSelectedIndex();
                        FileReader fin = new FileReader(new File("src\\Database\\Reports\\raport---"+acc.get(userIndex).getUsername()+"---"+index+".txt"));
                        Scanner in = new Scanner(fin);
    
                        String a = in.next();
                        String b = in.next();
                        String c = "";
                        while (in.hasNextLine()) {
                            String line = in.nextLine(); 
                            Scanner lineScanner = new Scanner(line); 
                            while (lineScanner.hasNext()) {
                                c += lineScanner.next() + " "; 
                            }
                            c += "\n"; 
                            lineScanner.close(); 
                        }
                        
                        in.close();
                        reportInfo.setText(a);
                        reportInfo1.setText(b);
                        reportInfo2.setText(c);
                        // reportInfo
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

        
        try {
            appBuget.setText(Users.getBuget()+ " €");
        } catch (Exception e) {}
            
        try {   
            bugetLabel.setText(Users.getBuget() + " €");
        } catch (Exception e) {}
        try{
            settingsInfo.setText(acc.get(userIndex).getUsername()+ "\n" +acc.get(userIndex).getEmail() + "\n" +acc.get(userIndex).getNume() + "\n" +acc.get(userIndex).getPrenume() + "\n" + acc.get(userIndex).getCreationDate() + "\n" + acc.get(userIndex).getRaport());
        }
        catch(Exception e){}
        try {
            settingsInfo1.setText("User name: "+"\n"+"Email: "+"\n"+"Nume: "+"\n"+"Prenume:"+"\n"+ "Data crearii contului:"+"\n"+"Numarul de rapoarte:");
        } catch (Exception e) {}
    
    }
}
