package org.example.project.util;

import org.example.project.model.GeoCoordinate;
import org.example.project.model.RoutWay;
import org.example.project.model.RouteNode;

import java.util.ArrayList;

public class Navigation {
    UtilCoordinates utilCoordinates = new UtilCoordinates();


    public RouteNode getClosestNode(GeoCoordinate start, ArrayList<RouteNode> nodes) {

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

    public ArrayList<RoutWay> getRoutsFromNode(RouteNode node, ArrayList<RoutWay> routs) {
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

    public ArrayList<Long> findNeighboursId(RouteNode currentNode, ArrayList<RoutWay> possibleRouts) {
        ArrayList<Long> neighboursId = new ArrayList<>();

        for (RoutWay rout : possibleRouts) {
            for (int i = 0; i < rout.getNodesId().size(); i++) {
                if (rout.getNodesId().get(i) == currentNode.getId()){
                    if (i > 0) {
                        neighboursId.add(rout.getNodesId().get(i - 1));
                    }
                    if (i < rout.getNodesId().size() - 1) {
                        neighboursId.add(rout.getNodesId().get(i + 1));
                    }
                }
            }
        }
        return neighboursId;
    }

    public ArrayList<RouteNode> findNeighboursNodes(ArrayList<Long> neighboursId, ArrayList<RouteNode> nodes) {
        ArrayList<RouteNode> neighboursNodes = new ArrayList<>();
        for (Long id : neighboursId) {
            for (RouteNode node : nodes) {
                if (node.getId() == id) {
                    neighboursNodes.add(node);
                }
            }
        }
        return neighboursNodes;
    }


        public void setNeighbourDistances(ArrayList<RouteNode> neighbours, RouteNode currentNode, RouteNode endNode){
            for (RouteNode neighbour : neighbours) {
                double coveredDistance = currentNode.getCostToReachNode();
                coveredDistance += utilCoordinates.haversineDistance(currentNode.getCoordinate(), neighbour.getCoordinate());
                neighbour.setCostToReachNode(coveredDistance);
                neighbour.setEstimatedCostToGaol(utilCoordinates.haversineDistance(neighbour.getCoordinate(), endNode.getCoordinate()));
            }

    }
}
