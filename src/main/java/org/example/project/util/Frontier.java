package org.example.project.util;

import org.example.project.model.Node;
import org.example.project.model.RouteNode;

import java.util.ArrayList;

public class Frontier {
    private ArrayList<RouteNode> frontier = new ArrayList<>();

    public void addNode(RouteNode node) {
        frontier.add(node);
    }

    public void addNodes(ArrayList<RouteNode> neighbours) {
       for (RouteNode neighbour : neighbours) {
           if (!frontier.contains(neighbour) && !neighbour.getExplored()) {
               frontier.add(neighbour);
           }
       }
    }

    public RouteNode removeNode() {
        double cost = Double.MAX_VALUE;
        RouteNode nextNode = null;
        int indexToRemove = 0;
        for (int i = 0; i < frontier.size(); i++) {
            if (cost > frontier.get(i).getEstimatedCostToGoal() + frontier.get(i).getCostToReachNode()) {
                cost = frontier.get(i).getEstimatedCostToGoal() + frontier.get(i).getCostToReachNode();
                indexToRemove = i;
            }
        }
        nextNode = frontier.get(indexToRemove);
        nextNode.setExplored(true);
        frontier.remove(indexToRemove);
        return nextNode;
    }
}
