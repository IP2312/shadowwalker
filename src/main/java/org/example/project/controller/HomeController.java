package org.example.project.controller;

import org.example.project.model.*;
import org.example.project.services.OverpassServices;
import org.example.project.util.UtilCoordinates;
import org.example.project.view.View;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;

public class HomeController {
    View view = new View();
    OverpassServices overpassServices = new OverpassServices();
    ArrayList<Way> routs = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();
    UtilCoordinates utilCoordinates = new UtilCoordinates();




    public void calculateDistance(){
        GeoCoordinate startPoint = view.getStartPoint();
        GeoCoordinate destinationPoint = view.getDestinationPoint();
        System.out.println("Harvsindistance:");
        System.out.println(utilCoordinates.haversineDistance(startPoint, destinationPoint));
        System.out.println("Distance: ");
        Coordinate coordinate1 = new Coordinate(startPoint.getLat(),startPoint.getLon());
        Coordinate coordinate2 = new Coordinate(destinationPoint.getLat(),destinationPoint.getLon());
        System.out.println(coordinate1.distance(coordinate2));
    }


    public void loadMapObjects(){
         OverpassResponse result  = overpassServices.getRouts();

         for (OverpassElement element : result.elements){
             System.out.println(element.type + " " + element.id);
             if (element.type.equals("way")){
                routs.add(new Way(element.id, "road", (ArrayList<Long>) element.nodes));
             } else if (element.type.equals("node")) {
                 nodes.add(new Node((int) element.id, new GeoCoordinate(element.lat, element.lon)));
             }
         }
    }




}
