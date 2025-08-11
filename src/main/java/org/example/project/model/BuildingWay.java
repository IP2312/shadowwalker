package org.example.project.model;

import java.util.ArrayList;

public class BuildingWay implements Way {
    private long id;
    private String type;
    private ArrayList<Long> nodesId;

    public BuildingWay(long id, String type, ArrayList<Long> nodesId) {
        setId(id);
        setType(type);
        setNodesId(nodesId);
    }


    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        try {
            this.id = Long.parseLong(String.valueOf(id));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Id is not a number");
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String input) {
        this.type = input;
    }

    @Override
    public ArrayList<Long> getNodesId() {
        return nodesId;
    }

    @Override
    public void setNodesId(ArrayList<Long> nodesId) {
        this.nodesId = nodesId;
    }
}
