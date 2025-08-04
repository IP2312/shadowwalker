package org.example.project.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/osm")
public class OverpassController {
    private final OverpassServices overpassServices;

    public OverpassController(OverpassServices overpassServices) {
        this.overpassServices = overpassServices;
    }

    @RequestMapping("/buildings")
    public ResponseEntity<String> getBuildings(){
        OverpassResponse result = overpassServices.getBuildingsNearPoints();
        for (Element element : result.elements) {
            System.out.println(element.type + " " + element.id);
        }

        return ResponseEntity.ok(result.toString());
    }
}
