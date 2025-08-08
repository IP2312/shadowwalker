package org.example.project.model;

public class RouteNode implements Node {
    private long id;
    private GeoCoordinate coordinate;
    private boolean intersection;
    private double costToReachNode;
    private double estimatedCostToGaol;
    private RouteNode parentNode;
    private RouteNode childNode;


    public RouteNode(long id, GeoCoordinate coordinate, boolean intersection) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = intersection;
        this.costToReachNode = 0;
        this.estimatedCostToGaol = 0;
        this.childNode = null;
        this.parentNode = null;

    }

    public RouteNode(long id, GeoCoordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = false;
        this.costToReachNode = 0;
        this.estimatedCostToGaol = 0;
        this.childNode = null;
        this.parentNode = null;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public GeoCoordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(GeoCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public double getCostToReachNode() {
        return costToReachNode;
    }

    public void setCostToReachNode(double costToReachNode) {
        this.costToReachNode = costToReachNode;
    }

    public double getEstimatedCostToGaol() {
        return estimatedCostToGaol;
    }

    public void setEstimatedCostToGaol(double estimatedCostToGaol) {
        this.estimatedCostToGaol = estimatedCostToGaol;
    }

    @Override
    public String toString() {
        return "RouteNode{" +
                "id=" + id +
                ", coordinate=" + coordinate +
                ", intersection=" + intersection +
                ", costToReachNode=" + costToReachNode +
                ", estimatedCostToGaol=" + estimatedCostToGaol +
                '}';
    }
}
