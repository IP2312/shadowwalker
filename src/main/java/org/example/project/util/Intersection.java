package org.example.project.util;

import org.example.project.model.BuildingNode;
import org.example.project.model.BuildingWay;
import org.example.project.model.GeoCoordinate;
import org.locationtech.jts.geom.*;

import java.util.ArrayList;


public class Intersection {


    public void intersection(GeoCoordinate start, GeoCoordinate end, BuildingWay building, ArrayList<BuildingNode> nodes) {
        GeometryFactory gf = new GeometryFactory();

        Coordinate[] polygonCoords = new Coordinate[building.getNodesId().size()];

        for (int i = 0; i < building.getNodesId().size(); i++) {
            building.getNodesId().get(i);
            for (BuildingNode node : nodes) {
                if (node.getId() == building.getNodesId().get(i)) {
                    polygonCoords[i] = new Coordinate(node.getCoordinate().getLat(), node.getCoordinate().getLon());
                }
            }
        }
//        {
////                new Coordinate(48.30831037671277, 14.288051640589828),
////                new Coordinate(48.30902218628471, 14.289376651816868),
////                new Coordinate(48.30863105620982, 14.288962609546102),
////                new Coordinate(48.30817011793251, 14.288193521150745),
////                new Coordinate(48.30831037671277, 14.288051640589828)
//        };
        Polygon polygon = gf.createPolygon(polygonCoords);

        // Define a line that intersects the polygon
        Coordinate[] lineCoords = new Coordinate[]{
                new Coordinate(start.getLat(), start.getLon()),
                new Coordinate(end.getLat(), end.getLon())
        };
        LineString line = gf.createLineString(lineCoords);

        boolean intersects = polygon.intersects(line);
        Geometry intersection = polygon.intersection(line);

        System.out.println("Intersects? " + intersects);
        System.out.println("Intersection geometry: " + intersection);

    }
}
