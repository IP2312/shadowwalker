package org.example.project;

import org.example.project.controller.HomeController;
import org.example.project.model.GeoCoordinate;
import org.example.project.model.RouteNode;
import org.example.project.util.Navigation;
import org.example.project.util.SunPositon;
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
        Navigation navigation = new Navigation();
        View view = new View();

        homeController.calculateDistance();
        homeController.loadRouteObjects();
        homeController.loadBuildingObjects();
        ArrayList<RouteNode> shortestPath = homeController.findeRout(view.getStartPoint(), view.getDestinationPoint());
        System.out.println(ZonedDateTime.now());



        RouteNode testNode = new RouteNode(1, new GeoCoordinate(48.30975485728436, 14.293327037834715));
        GeoCoordinate geoCoordinate = sunPositon.calculateLineForSunray(testNode, ZonedDateTime.now());
        System.out.println(geoCoordinate);
        homeController.checkForShade(testNode);

    }

}
