package org.example.project.model;

public class RouteNode implements Node {
    private long id;
    private GeoCoordinate coordinate;
    private boolean intersection;


    public RouteNode(long id, GeoCoordinate coordinate, boolean intersection) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = intersection;
    }

    public RouteNode(long id, GeoCoordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
        this.intersection = false;
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


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", coordinate=" + coordinate +
                '}';
    }
}
