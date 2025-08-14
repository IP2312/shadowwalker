package org.example.project.controller;

import org.example.project.model.*;
import org.example.project.services.OverpassServices;
import org.example.project.util.*;
import org.example.project.view.View;
import org.locationtech.jts.geom.Coordinate;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class HomeController {
    View view = new View();
    OverpassServices overpassServices = new OverpassServices();
    ArrayList<RoutWay> routs = new ArrayList<>();
    ArrayList<RouteNode> routeNodes = new ArrayList<>();
    ArrayList<BuildingNode> buildingNodes = new ArrayList<>();
    ArrayList<BuildingWay> buildings = new ArrayList<>();
    UtilCoordinates utilCoordinates = new UtilCoordinates();
    Navigation navigation = new Navigation();
    Frontier frontier = new Frontier();
    SunPositon sunPositon = new SunPositon();
    Intersection intersection = new Intersection();


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


    public void loadRouteObjects() {
        OverpassResponse result = overpassServices.getRouts();

        for (OverpassElement element : result.elements) {

            if (element.type.equals("way")) {
                routs.add(new RoutWay(element.id, "road", (ArrayList<Long>) element.nodes));
            } else if (element.type.equals("node")) {
                routeNodes.add(new RouteNode((long) element.id, new GeoCoordinate(element.lat, element.lon)));

            }
        }
    }


    public void loadBuildingsObjects() {
        OverpassResponse result = overpassServices.getBuildingsNearPoints();
        for (OverpassElement element : result.elements) {
            if (element.type.equals("way")) {
                buildings.add(new BuildingWay(element.id, "building", (ArrayList<Long>) element.nodes));
            } else if (element.type.equals("node")) {
                buildingNodes.add(new BuildingNode((long) element.id, new GeoCoordinate(element.lat,element.lon)));
            }
        }
    }


    public ArrayList<RouteNode> findeRout(GeoCoordinate startPoint, GeoCoordinate endPoint) {


        RouteNode startNode = navigation.getClosestNode(startPoint, routeNodes);
        RouteNode endNode = navigation.getClosestNode(endPoint, routeNodes);
        RouteNode currentNode = startNode;
        currentNode.setExplored(true);

        do {

            ArrayList<RoutWay> possibleRouts = navigation.getRoutsFromNode(currentNode, routs);
            ArrayList<Long> neighbourIds = navigation.findNeighboursId(currentNode, possibleRouts);
            ArrayList<RouteNode> neighboursNodes = navigation.findNeighboursNodes(neighbourIds, routeNodes);
            navigation.setNeighbourDistances(neighboursNodes, currentNode, endNode);
            frontier.addNodes(neighboursNodes);

            currentNode.setChildNode(frontier.removeNode());
            currentNode.getChildNode().setParentNode(currentNode);

            currentNode = currentNode.getChildNode();

        } while (!currentNode.equals(endNode));

        System.out.println(currentNode);

        ArrayList<RouteNode> shortestPath = new ArrayList<>();

        while (currentNode.getParentNode() != null) {
            shortestPath.add(currentNode);
            currentNode = currentNode.getParentNode();
        }

        System.out.println(shortestPath);
        return shortestPath;

    }

    public void checkForShade(RouteNode currentNode) {
        GeoCoordinate RayEnd = sunPositon.calculateLineForSunray(currentNode, ZonedDateTime.now());
        GeoCoordinate RayStart = currentNode.getCoordinate();
        for (BuildingWay buildingWay : buildings) {
            intersection.intersection(RayStart, RayEnd, buildingWay, buildingNodes);

        }
    }
}
