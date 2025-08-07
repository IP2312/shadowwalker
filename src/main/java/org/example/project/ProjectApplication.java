package org.example.project;

import org.example.project.controller.HomeController;
import org.example.project.model.RouteNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
        HomeController homeController = new HomeController();

        homeController.calculateDistance();
        homeController.loadMapObjects();
        RouteNode closestNode = homeController.getClosestNode();
        System.out.println(closestNode);
        System.out.println(homeController.getRoutFromNode(closestNode));







    }

}
