package Interface;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

public class app {
    public VBox root = new VBox();

    public app(){
        root.setPrefHeight(400);
        root.setPrefWidth(640);
        
        



        MenuBar menuBar = new MenuBar();
        Button toNewReport = new Button("Raport nou");
        toNewReport.setBackground(Background.EMPTY);
        Button toMyReports = new Button("Rapoartele mele");
        toMyReports.setBackground(Background.EMPTY);
        Button settings = new Button("Setari");
        settings.setBackground(Background.EMPTY);
        Button delogare = new Button("Delogare");
        delogare.setBackground(Background.EMPTY);

        Menu m1 = new Menu();
        Menu m2 = new Menu();
        Menu m3 = new Menu();
        Menu m4 = new Menu();
        m1.setGraphic(toNewReport);
        m2.setGraphic(toMyReports);
        m3.setGraphic(settings);
        m4.setGraphic(delogare);
        menuBar.getMenus().addAll(m1,m2,m3,m4);



        root.getChildren().addAll(menuBar);
    }
}
