package model;

public interface Builder {

    public void addRedTriangle(Double [] coords);
    public void addGreenTriangle(Double [] coords);
    public void addYellowTriangle(Double [] coords);
    public void addArrow(int start, int end, Double[] coords);

    public Indicator build();
}