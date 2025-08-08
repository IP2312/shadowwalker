package org.example.project.controller;

import org.example.project.model.CoordinateDTO;
import org.example.project.model.OverpassElement;
import org.example.project.services.OverpassServices;
import org.example.project.model.OverpassResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("Map from Restcontroller");
        return List.of(
                new CoordinateDTO(48.30949476831703, 14.29304903467718),
                new CoordinateDTO(48.309911657762406, 14.2919921025157),
                new CoordinateDTO(48.31334731019215, 14.294036430536547),
                new CoordinateDTO(48.31286419963752, 14.29509336270001),
                new CoordinateDTO(48.31062975693254, 14.292077270927331)
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
