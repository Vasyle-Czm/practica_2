import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewManagerController implements Initializable{

    @FXML
    Button confirm;
    @FXML
    TextField email,username,nume,prenume,parola;
    @FXML
    static Label message;

    public void backToManagerApp(ActionEvent event) throws IOException{
        Parent t1 = FXMLLoader.load(getClass().getResource("Interface\\managerApp.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(t1));    
    }

    private void save() throws IOException{
        FileWriter save = new FileWriter(new File("src\\Database\\managersInfo.txt"));
        for(int i = 0;i<Controller.manAcc.size();i++){
            save.write(Controller.manAcc.get(i).getEmail() + " " + Controller.manAcc.get(i).getUsername() + " " + Controller.manAcc.get(i).getNume() + " " + Controller.manAcc.get(i).getPrenume() + " " + Controller.manAcc.get(i).getParola() + " " + Controller.manAcc.get(i).getCreationDate() + "\n");
        }
        save.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirm.setOnAction(e -> {
            message.setVisible(false);



            if(email.getText().trim().isEmpty() || username.getText().trim().isEmpty() || nume.getText().trim().isEmpty() || prenume.getText().trim().isEmpty() || parola.getText().trim().isEmpty()){
                message.setText("Nu puteti lăsa câmpuri libere!");
                message.setVisible(true);
            }
            else{
                boolean k = false;
                for(int i=0;i<Controller.manAcc.size();i++){
                    if(Controller.manAcc.get(i).getUsername().equals(username.getText()) || Controller.manAcc.get(i).getEmail().equals(email.getText())){
                        k = true;
                        break;
                    }
                }
    
                if(k == true){
                    message.setVisible(true);
                    message.setText("Contul deja există");
                }
                else{
                    Controller.manAcc.add(new Manageri(email.getText(), username.getText(), nume.getText(), prenume.getText(), parola.getText()));
                    try {
                        save();
                    } catch (IOException e1) {
                        System.out.println("EROARE DE SALVARE IN FISIER");
                    }
                }
            }
        });
    }
}
