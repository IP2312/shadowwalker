package org.example.project.model;

import org.example.project.controller.Objects;

import java.util.ArrayList;
import java.util.Arrays;

public class Way {
    private long id;
    private String type;
    private ArrayList<Long> nodesId;

    public Way(long id, String type, ArrayList<Long> nodesId) {
        setId(id);
        setType(type);
        setNodesId(nodesId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        try {
            this.id = Long.parseLong(String.valueOf(id));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Id is not a number");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String input) {
        if (Arrays.stream(Objects.values())
                .anyMatch(e -> e.name().equalsIgnoreCase(input))) {
            this.type = input.toLowerCase();
        }else {
            throw new IllegalArgumentException("Type is not valid");


        }

    }

    public ArrayList<Long> getNodesId() {
        return nodesId;
    }

    public void setNodesId(ArrayList<Long> nodesId) {
        this.nodesId = nodesId;
    }

    @Override
    public String toString() {
        return "Way{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", nodes=" + nodesId +
                '}';
    }
}
