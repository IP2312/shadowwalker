package org.example.project;

import org.example.project.controller.HomeController;
import org.example.project.model.GeoCoordinate;
import org.example.project.model.RouteNode;
import org.example.project.util.SunPositon;
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
        View view = new View();


        homeController.loadBuildingObjects();

        homeController.loadRouteObjects();
        homeController.findeRout(view.getStartPoint(),view.getDestinationPoint());



        GeoCoordinate coordinate = new GeoCoordinate(48.31023441420293, 14.293996996365124);
        RouteNode currentNode = new RouteNode(1, coordinate );
       // homeController.checkForShade(currentNode);


    }

}
