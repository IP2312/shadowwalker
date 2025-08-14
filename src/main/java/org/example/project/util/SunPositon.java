package org.example.project.util;


import org.example.project.model.GeoCoordinate;
import org.example.project.model.RouteNode;
import org.shredzone.commons.suncalc.SunPosition;

import java.time.ZonedDateTime;

public class SunPositon {

    public double getAzimuth(double lat, double lon, ZonedDateTime time){
        SunPosition position = SunPosition.compute()
                .at(lat, lon)
                .on(time)
                .execute();

        return position.getAzimuth();
    }

    public double getElevation(double lat, double lon, ZonedDateTime time){
        SunPosition position = SunPosition.compute()
                .at(lat, lon)
                .on(time)
                .execute();

        return position.getAltitude();
    }

    public GeoCoordinate calculateLineForSunray(RouteNode node, ZonedDateTime time){
        double lat = node.getCoordinate().getLat();
        double lon = node.getCoordinate().getLon();
        double azimuth = getAzimuth(lat,lon, time);
        System.out.println("Azimuth: " + azimuth);
        System.out.println("Elevation" + getElevation(lat,lon,time));
        double distanceMeters = 200;
        double R = 6371000.0; // Earth radius in meters
        double bearing = Math.toRadians(azimuth);

        double lat1 = Math.toRadians(lat);
        double lon1 = Math.toRadians(lon);

        double lat2 = Math.asin(
                Math.sin(lat1) * Math.cos(distanceMeters / R) +
                        Math.cos(lat1) * Math.sin(distanceMeters / R) * Math.cos(bearing)
        );

        double lon2 = lon1 + Math.atan2(
                Math.sin(bearing) * Math.sin(distanceMeters / R) * Math.cos(lat1),
                Math.cos(distanceMeters / R) - Math.sin(lat1) * Math.sin(lat2)
        );

       return new GeoCoordinate(Math.toDegrees(lat2), Math.toDegrees(lon2));
    }


}
