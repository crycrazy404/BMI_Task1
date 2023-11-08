package model;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Indicator{
    private HBox panel = new HBox();
    public void add(Pane pane){
        panel.getChildren().remove(pane);
        panel.getChildren().add(pane);
    }
    public void show(Pane pane){
        pane.getChildren().remove(panel);
        pane.getChildren().add(panel);
    }
}