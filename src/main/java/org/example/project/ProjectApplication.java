package org.example.project;

import org.example.project.services.SunPositon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
        SunPositon sunPositon = new SunPositon();

        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
        System.out.println("Azimuth:");
        System.out.println( sunPositon.getAzimuth(48.30949476831703, 14.29304903467718, time));
        System.out.println("Elevation:");
        System.out.println( sunPositon.getElevation(48.30949476831703, 14.29304903467718, time));



    }

}
