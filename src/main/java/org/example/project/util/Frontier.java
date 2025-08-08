package org.example.project.util;

import org.example.project.model.Node;
import org.example.project.model.RouteNode;

import java.util.ArrayList;

public class Frontier {
    private ArrayList<RouteNode> nodes;

    public void addNode(RouteNode node) {
        nodes.add(node);
    }

    public void addNodes(ArrayList<RouteNode> neighbours) {
        nodes.addAll(neighbours);
    }

    public RouteNode removeNode() {
        double cost = Double.MAX_VALUE;
        RouteNode nextNode = null;
        for (int i = 0; i < nodes.size(); i++) {
            if (cost > nodes.get(i).getEstimatedCostToGoal() + nodes.get(i).getCostToReachNode()) {
                cost = nodes.get(i).getEstimatedCostToGoal() + nodes.get(i).getCostToReachNode();
                nextNode = nodes.get(i);
                nodes.remove(i);
            }
        }
        return nextNode;
    }
}
