package org.example.project.services;

import org.shredzone.commons.suncalc.SunTimes;

import java.time.ZonedDateTime;

public class SunPositon {

    public double getAzimuth(double lat, double lon, ZonedDateTime time){
        SunTimes times = SunTimes.compute()
                .on(time)   // set a date
                .at(lat, lon)   // set a location
                .execute();     // get the results
        System.out.println("Sunrise: " + times.getRise());
        System.out.println("Sunset: " + times.getSet());
        return 0;
    }
}
