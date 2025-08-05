package org.example.project.services;


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
}
