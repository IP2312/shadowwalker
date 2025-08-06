package org.example.project.model;

import org.locationtech.jts.geom.Coordinate;

public class Node {
    private int id;
    private Coordinate coordinate;;

    public Node(int id, Coordinate coordinate) {
        this.id = id;
        this.coordinate = coordinate;
    }
}
