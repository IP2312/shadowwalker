package org.example.project.controller;

import org.example.project.model.CoordinateDTO;
import org.example.project.model.OverpassElement;
import org.example.project.model.RouteNode;
import org.example.project.services.OverpassServices;
import org.example.project.model.OverpassResponse;
import org.example.project.view.View;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
public class OverpassRestController {
    private final OverpassServices overpassServices;

    public OverpassRestController(OverpassServices overpassServices) {
        this.overpassServices = overpassServices;
    }

    @GetMapping("/nodes")
    public List<CoordinateDTO> getNodes() {
        View view = new View();
        System.out.println("Map from Restcontroller");
        return List.of(
                new CoordinateDTO(view.getStartPoint().lat, view.getStartPoint().lon),
                new CoordinateDTO(view.getDestinationPoint().lat, view.getDestinationPoint().lon)
        );
    }

    @RequestMapping("/routs")
    public ResponseEntity<String> getRouts() {
        OverpassResponse result = overpassServices.getRouts();
        System.out.println("routs:");
        for (OverpassElement element : result.elements) {
            System.out.println(element.type + " " + element.id);
        }
        return ResponseEntity.ok(result.toString());

    }

    @RequestMapping("/buildings")
    public ResponseEntity<String> getBuildings(){
        OverpassResponse result = overpassServices.getBuildingsNearPoints();
        System.out.println("buildings:");
        for (OverpassElement element : result.elements) {
            System.out.println(element.type + " " + element.id);
        }
        return ResponseEntity.ok(result.toString());
    }

}
