package com.example.bmi;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Director;
import model.Indicator;

public class HelloController {
    private final BMI bmi = new BMI();
    Alert alt = new Alert(Alert.AlertType.ERROR);
    @FXML
    public Label imtLabel;
    public TextField Weight;
    @FXML
    public TextField Lenght;
    @FXML
    public Pane imtGraphics;
    public Pane chart;
    public Director director = new Director();
    public Indicator indicator;

    @FXML
    protected void onBmiCalculate() {
        Double[] coordR = new Double[]{50.0, 0.0, 0.0, 100.0, 100.0, 100.0};
        Double[] coordY = new Double[]{50.0, 0.0, 100.0, 100.0, 150.0, 0.0};
        Double[] coordG = new Double[]{150.0, 0.0, 100.0, 100.0, 200.0, 100.0};
        Double[] coordAR = new Double[]{40.0, 75.0, 60.0, 55.0, 40.0, 55.0};
        Double[] coordAY = new Double[]{90.0, 50.0, 110.0, 50.0, 100.0, 40.0};
        Double[] coordAG = new Double[]{140.0, 60.0, 160.0, 58.0, 150.0, 75.0};
        try{
            bmi.setW(Double.parseDouble(Weight.getText()));
            bmi.setL(Double.parseDouble(Lenght.getText()));
            imtLabel.setVisible(true);
            double value = Double.parseDouble(String.valueOf(bmi.BmiCalc()));
            if(value >= 0 && value <= 16 || value >= 30){
                indicator = director.Constr(coordR, coordY, coordG, 50, 65 ,coordAR);
                indicator.show(chart);
                imtLabel.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            } else if (value >= 16 && value <= 18.5 || value >= 25 && value < 30) {
                indicator = director.Constr(coordR, coordY, coordG,100, 50 ,coordAY);
                indicator.show(chart);
                imtLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            }else{
                indicator = director.Constr(coordR, coordY, coordG, 150, 65 ,coordAG);
                indicator.show(chart);
                imtLabel.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            imtLabel.setText(String.valueOf(bmi));
        }catch (Exception e){
            alt.setTitle("Ошибка!");
            alt.setHeaderText(null);
            alt.setContentText(String.valueOf(e));
            alt.showAndWait();
        }
    }
}