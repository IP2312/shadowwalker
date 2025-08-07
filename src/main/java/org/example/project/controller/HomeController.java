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
    ArrayList<RoutWay> routs = new ArrayList<>();
    ArrayList<RouteNode> nodes = new ArrayList<>();
    UtilCoordinates utilCoordinates = new UtilCoordinates();


    public void calculateDistance() {
        GeoCoordinate startPoint = view.getStartPoint();
        GeoCoordinate destinationPoint = view.getDestinationPoint();
        System.out.println("Harvsindistance:");
        System.out.println(utilCoordinates.haversineDistance(startPoint, destinationPoint));
        System.out.println("Distance: ");
        Coordinate coordinate1 = new Coordinate(startPoint.getLat(), startPoint.getLon());
        Coordinate coordinate2 = new Coordinate(destinationPoint.getLat(), destinationPoint.getLon());
        System.out.println(coordinate1.distance(coordinate2) * 100000);
        Coordinate test1 = new Coordinate(0, 3);
        Coordinate test2 = new Coordinate(4, 0);
        System.out.println(test1.distance(test2));

    }


    public void loadMapObjects() {
        OverpassResponse result = overpassServices.getRouts();

        for (OverpassElement element : result.elements) {

            if (element.type.equals("way")) {
                routs.add(new RoutWay(element.id, "road", (ArrayList<Long>) element.nodes));
            } else if (element.type.equals("node")) {
                nodes.add(new RouteNode((long) element.id, new GeoCoordinate(element.lat, element.lon)));

            }
        }
    }


    public RouteNode getClosestNode() {
        GeoCoordinate start = view.getStartPoint();

        double distance = Double.MAX_VALUE;
        RouteNode currentNode = null;
        for (RouteNode node : nodes) {
            if (distance > utilCoordinates.haversineDistance(start, node.getCoordinate())) {
                distance = utilCoordinates.haversineDistance(start, node.getCoordinate());
                currentNode = node;
            }
        }
        return currentNode;
    }

    public ArrayList<RoutWay> getRoutFromNode(RouteNode node) {
        ArrayList<RoutWay> newRouts = new ArrayList<>();
        for (RoutWay rout : routs) {
            for (Long nodeId : rout.getNodesId()) {
                if (nodeId == node.getId()) {
                    newRouts.add(rout);
                }
            }
        }
        return newRouts;
    }


}
