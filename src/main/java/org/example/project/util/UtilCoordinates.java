package org.example.project.util;

import org.example.project.model.GeoCoordinate;

public class UtilCoordinates {
    public double haversineDistance(GeoCoordinate coordinate1, GeoCoordinate coordinate2) {

        double lat1 = coordinate1.getLat();
        double lon1 = coordinate1.getLon();

        double lat2 = coordinate2.getLat();
        double lon2 = coordinate2.getLon();


        final int R = 6371000; // Radius of the earth in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // in meters
    }

}
