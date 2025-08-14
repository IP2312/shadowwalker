package org.example.project.model;

import java.util.ArrayList;

public class BuildingNode implements Node {
    private long id;
  private GeoCoordinate coordinate;



    public BuildingNode(long id, GeoCoordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
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
}




