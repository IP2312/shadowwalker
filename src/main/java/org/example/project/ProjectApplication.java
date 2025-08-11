package org.example.project;

import org.example.project.controller.HomeController;
import org.example.project.model.RouteNode;
import org.example.project.model.SunPositon;
import org.example.project.util.UtilCoordinates;
import org.example.project.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
        HomeController homeController = new HomeController();
        UtilCoordinates utilCoordinates = new UtilCoordinates();
        SunPositon sunPositon = new SunPositon();
        View view = new View();

        homeController.calculateDistance();
        homeController.loadRouteObjects();
        ArrayList<RouteNode> shortestPath = homeController.findeRout(view.getStartPoint(), view.getDestinationPoint());
        System.out.println(sunPositon.getAzimuth(view.getStartPoint().lat, view.getStartPoint().lon, ZonedDateTime.now()));

    }

}
