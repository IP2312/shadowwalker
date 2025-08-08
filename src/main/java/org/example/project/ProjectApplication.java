package org.example.project;

import org.example.project.controller.HomeController;
import org.example.project.model.RouteNode;
import org.example.project.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
        HomeController homeController = new HomeController();
        View view = new View();

        homeController.calculateDistance();
        homeController.loadMapObjects();
        homeController.findeRout(view.getStartPoint(),view.getDestinationPoint());






    }

}
