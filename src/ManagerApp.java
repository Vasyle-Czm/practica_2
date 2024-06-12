import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ManagerApp {
    public VBox root = new VBox();
    public ManagerApp(){
        root.setMinHeight(600);
        root.setMinWidth(1100);




        Menu menu = new Menu();
        menu.setMnemonicParsing(false);
        Button delogare = new Button("Delogare");
        delogare.setOnAction(e -> {
            Stage stage = (Stage) delogare.getScene().getWindow();
            Login o = new Login();
            stage.setScene(new Scene(o.root));
        });
        delogare.setMnemonicParsing(false);
        delogare.setBackground(Background.EMPTY);
        menu.setGraphic(delogare);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);


        SplitPane sp = new SplitPane();
        sp.setDividerPositions(0.2505567928730512,0.7505567928730512);
        sp.setFocusTraversable(true);
        sp.setPrefHeight(-1);
        sp.setPrefWidth(-1);


        AnchorPane ap1 = new AnchorPane();
        ap1.setPrefHeight(551);
        ap1.setPrefWidth(100);
        Label m1 = new Label("Lista de utilizatori:");
        m1.setAlignment(Pos.CENTER);
        m1.setLayoutX(14);
        m1.setLayoutY(14);
        m1.setMinWidth(60);
        m1.prefHeight(-1);
        m1.setTextFill(Color.GRAY);
        m1.setTextAlignment(TextAlignment.CENTER);
        m1.setWrapText(false);
        m1.setFont(new Font(18));
        ListView<String> users = new ListView<>();
        users.setLayoutX(11);
        users.setLayoutY(51);
        users.setPrefHeight(480);
        users.setPrefWidth(200);


        AnchorPane ap2 = new AnchorPane();
        ap2.setPrefHeight(545);
        ap2.setPrefWidth(474);
        Label selectUser = new Label("Selectati un utilizator pentru mai multe detalii");
        selectUser.setFont(new Font(20));
        selectUser.setTextFill(Color.GRAY);
        selectUser.setLayoutX(14);
        selectUser.setLayoutY(14);
        selectUser.setAlignment(Pos.CENTER);
        selectUser.setAlignment(Pos.CENTER);
        selectUser.setWrapText(false);
        Label l1 = new Label();
        l1.setLayoutX(199);
        l1.setLayoutY(66);
        l1.setFont(new Font(15));
        Label infoLabel = new Label();
        infoLabel.setLayoutX(30);
        infoLabel.setLayoutY(66);
        infoLabel.setFont(new Font(15));
        Button activare = new Button("Activare");
        activare.setLayoutX(41);
        activare.setLayoutY(484);
        activare.setMnemonicParsing(false);
        Button dezactivare = new Button("Dezactivare");
        dezactivare.setLayoutX(333);
        dezactivare.setLayoutY(484);
        dezactivare.setMnemonicParsing(false);
        Button stergere = new Button("Stergere");
        stergere.setLayoutX(197);
        stergere.setLayoutY(484);
        stergere.setMnemonicParsing(false);



        AnchorPane ap3 = new AnchorPane();
        Label detalii = new Label("Detalii");
        detalii.setTextFill(Color.GRAY);
        detalii.setFont(new Font(20));
        detalii.setLayoutX(14);
        detalii.setLayoutY(14);

        ap3.getChildren().addAll(detalii);
        ap2.getChildren().addAll(selectUser,l1,infoLabel,activare,dezactivare,stergere);
        ap1.getChildren().addAll(m1,users);
        sp.getItems().addAll(ap1,ap2,ap3);

        root.getChildren().addAll(menuBar,sp);
    }
}