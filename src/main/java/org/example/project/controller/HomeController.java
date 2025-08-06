package org.example.project.controller;

import org.example.project.model.Node;
import org.example.project.model.OverpassElement;
import org.example.project.model.OverpassResponse;
import org.example.project.model.Way;
import org.example.project.services.OverpassServices;
import org.example.project.view.View;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;

public class HomeController {
    View view = new View();
    OverpassServices overpassServices = new OverpassServices();
    ArrayList<Way> routs = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();

    Coordinate startPoint = view.getStartPoint();
    Coordinate destinationPoint = view.getDestinationPoint();

    public void loadMapObjects(){
         OverpassResponse result  = overpassServices.getRouts();

         for (OverpassElement element : result.elements){
             System.out.println(element.type + " " + element.id);
             if (element.type.equals("way")){
                routs.add(new Way(element.id, "road", (ArrayList<Long>) element.nodes));
             } else if (element.type.equals("node")) {
                 nodes.add(new Node((int) element.id, new Coordinate(element.lat, element.lon)));
             }
         }
    }




}
