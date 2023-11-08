package model;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class ModelBuild implements Builder{
    public Indicator indicator = new Indicator();
    private Pane panel = new Pane();
    @Override
    public void addRedTriangle(Double[] coords) {
        Polygon redTriangle = new Polygon();
        redTriangle.getPoints().addAll(coords);
        redTriangle.setFill(Color.RED);
        panel.getChildren().remove(redTriangle);
        panel.getChildren().add(redTriangle);
    }

    @Override
    public void addGreenTriangle(Double[] coords) {
        Polygon greenTriangle = new Polygon();
        greenTriangle.getPoints().addAll(coords);
        greenTriangle.setFill(Color.GREEN);
        panel.getChildren().remove(greenTriangle);
        panel.getChildren().add(greenTriangle);
    }

    @Override
    public void addYellowTriangle(Double[] coords) {
        Polygon yellowTriangle = new Polygon();
        yellowTriangle.getPoints().addAll(coords);
        yellowTriangle.setFill(Color.YELLOW);
        panel.getChildren().remove(yellowTriangle);
        panel.getChildren().add(yellowTriangle);
    }

    public void addArrow(int x, int y, Double[] coords){
        Line arrow = new Line();
        arrow.setStartX(100);
        arrow.setStartY(100);
        arrow.setEndX(x);
        arrow.setEndY(y);
        Polygon arrowHead = new Polygon();
        arrowHead.getPoints().addAll(coords);
        arrowHead.setFill(Color.BLACK);
        panel.getChildren().removeAll(arrow, arrowHead);
        panel.getChildren().addAll(arrow, arrowHead);
    }

    @Override
    public Indicator build() {
        indicator.add(panel);
        return indicator;
    }
}