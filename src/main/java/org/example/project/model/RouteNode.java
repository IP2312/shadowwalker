package org.example.project.model;

public class RouteNode implements Node {
    private long id;
    private GeoCoordinate coordinate;
    private boolean intersection;
    private double costToReachNode;
    private double estimatedCostToGaol;
    private RouteNode parentNode;
    private RouteNode childNode;
    private boolean explored;


    public RouteNode(long id, GeoCoordinate coordinate, boolean intersection) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = intersection;
        this.costToReachNode = 0;
        this.estimatedCostToGaol = 0;
        this.childNode = null;
        this.parentNode = null;
        this.explored = false;
    }

    public RouteNode(long id, GeoCoordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = false;
        this.costToReachNode = 0;
        this.estimatedCostToGaol = 0;
        this.childNode = null;
        this.parentNode = null;
        this.explored = false;
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

    public double getEstimatedCostToGoal() {
        return estimatedCostToGaol;
    }

    public void setEstimatedCostToGaol(double estimatedCostToGaol) {
        this.estimatedCostToGaol = estimatedCostToGaol;
    }

    public RouteNode getChildNode(){
        return childNode;
    }
    public RouteNode getParentNode(){
        return parentNode;
    }
    public void setParentNode(RouteNode parentNode){
        this.parentNode = parentNode;
    }


    public void setChildNode(RouteNode childNode){
        this.childNode = childNode;
    }

    public boolean getExplored(){
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    @Override
    public String toString() {
        return "RouteNode{" +
                "id=" + id +
                ", coordinate=" + coordinate +
                ", intersection=" + intersection +
                ", costToReachNode=" + costToReachNode +
                ", estimatedCostToGaol=" + estimatedCostToGaol +
                ", parentNode=" + parentNode.getId() +
                ", explored=" + explored +
                '}';
    }
}
