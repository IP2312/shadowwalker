package org.example.project.services;

import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.*;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import java.util.Arrays;


public class Intersection {

    public static void main(String[] args) throws Exception {
        // Create geometry factory
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        // Define WGS84 and a projected CRS (e.g., UTM zone 33N)
        CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:4326", true);      // lat/lon
        CoordinateReferenceSystem targetCRS = CRS.decode("EPSG:32633", true);     // UTM zone 33N (suitable for Austria)

        // Create a transformer from WGS84 to UTM
        MathTransform transform = CRS.findMathTransform(sourceCRS, targetCRS, true);

        // Define polygon in lat/lon (building footprint)
        Coordinate[] polygonLatLon = new Coordinate[]{
                new Coordinate(14.2855, 48.3066),
                new Coordinate(14.2860, 48.3066),
                new Coordinate(14.2860, 48.3070),
                new Coordinate(14.2855, 48.3070),
                new Coordinate(14.2855, 48.3066) // close the polygon
        };

        // Define line in lat/lon (ray or path)
        Coordinate[] lineLatLon = new Coordinate[]{
                new Coordinate(14.2856, 48.3067),
                new Coordinate(14.2859, 48.3069)
        };

        // Transform coordinates to UTM
        Coordinate[] polygonUTM = new Coordinate[polygonLatLon.length];
        Coordinate[] lineUTM = new Coordinate[lineLatLon.length];
        for (int i = 0; i < polygonLatLon.length; i++) {
            polygonUTM[i] = JTS.transform(polygonLatLon[i], null, transform);
        }
        for (int i = 0; i < lineLatLon.length; i++) {
            lineUTM[i] = JTS.transform(lineLatLon[i], null, transform);
        }

        // Create JTS geometries
        Polygon polygon = geometryFactory.createPolygon(polygonUTM);
        LineString line = geometryFactory.createLineString(lineUTM);

        // Check for intersection
        boolean intersects = polygon.intersects(line);
        System.out.println("Does the line intersect the polygon? " + intersects);
    }

}
