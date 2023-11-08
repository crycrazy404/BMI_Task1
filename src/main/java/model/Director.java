package model;

public class Director {
    public ModelBuild build = new ModelBuild();
    public Indicator Constr(Double [] coordsR, Double [] coordsY,Double [] coordsG, int x, int y, Double[] coordsA){
        build.addRedTriangle(coordsR);
        build.addYellowTriangle(coordsY);
        build.addGreenTriangle(coordsG);
        build.addArrow(x, y, coordsA);
        return build.build();
    }
}