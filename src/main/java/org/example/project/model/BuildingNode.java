package org.example.project.model;

import java.util.ArrayList;

public class BuildingNode implements Node {
    private long id;
    private String type;
    private ArrayList<Long> nodesId;


    public BuildingNode(long id, String type, ArrayList<Long> nodesId) {
        this.id = id;
        this.type = type;
        this.nodesId = nodesId;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public GeoCoordinate getCoordinate() {
        return null;
    }

    @Override
    public void setCoordinate(GeoCoordinate coordinate) {

    }

    @Override
    public String toString() {
        return "";
    }
}
