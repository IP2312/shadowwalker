package org.example.project.model;

public interface Node {
    long getId();

    void setId(long id);

    GeoCoordinate getCoordinate();

    void setCoordinate(GeoCoordinate coordinate);

    @Override
    String toString();
}
