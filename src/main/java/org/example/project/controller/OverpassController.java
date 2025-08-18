package org.example.project.controller;

import org.example.project.services.OverpassServices;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class OverpassController {
    private final OverpassServices overpassServices;
    private Coordinate startPoint;
    private Coordinate end;

    public OverpassController(OverpassServices overpassServices) {
        this.overpassServices = overpassServices;
    }

    @RequestMapping("/map")
    public String map() {
        System.out.println("Map from controller");

        return "map.html";

    }







}
