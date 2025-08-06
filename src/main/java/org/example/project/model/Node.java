package org.example.project.model;

import org.locationtech.jts.geom.Coordinate;

public class Node {
    private int id;
    private GeoCoordinate coordinate;

    public Node(int id, GeoCoordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
    }
}
