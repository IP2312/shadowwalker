package org.example.project.model;

import org.locationtech.jts.geom.*;


public class Intersection {


    public void intersection() {
        GeometryFactory gf = new GeometryFactory();
        Coordinate[] polygonCoords = new Coordinate[]{
                new Coordinate(48.30831037671277, 14.288051640589828),
                new Coordinate(48.30902218628471, 14.289376651816868),
                new Coordinate(48.30863105620982, 14.288962609546102),
                new Coordinate(48.30817011793251, 14.288193521150745),
                new Coordinate(48.30831037671277, 14.288051640589828)
        };
        Polygon polygon = gf.createPolygon(polygonCoords);

        // Define a line that intersects the polygon
        Coordinate[] lineCoords = new Coordinate[]{
                new Coordinate(48.309019919646204, 14.28777227020463),
                new Coordinate(48.30833892064607, 14.289274727876327)
        };
        LineString line = gf.createLineString(lineCoords);

        boolean intersects = polygon.intersects(line);
        Geometry intersection = polygon.intersection(line);

        System.out.println("Intersects? " + intersects);
        System.out.println("Intersection geometry: " + intersection);

    }
}
