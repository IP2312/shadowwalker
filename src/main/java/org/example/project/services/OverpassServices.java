package org.example.project.services;

import org.example.project.model.OverpassResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OverpassServices {
    private final RestTemplate restTemplate;

    public OverpassServices() {
        this.restTemplate = new RestTemplate();
    }

    public OverpassResponse getBuildingsNearPoints() {
        String query = """
                [out:json][timeout:25];
                (
                  // Buildings with height
                  way(around:25, 48.30949476831703, 14.29304903467718)
                    ["building"]["height"];
                
                  // Buildings with number of levels
                  way(around:25, 48.30949476831703, 14.29304903467718)
                    ["building"]["building:levels"];
                
                );
                out body;
                >;
                out skel qt;
                """;
        return sendQuery(query);

    }

    public OverpassResponse getRouts() {
        String query = """
                [out:json][timeout:25];
                    // Bounding Box: [South, West, North, East]
                (
                way(48.309911657762406, 14.2919921025157, 48.31334731019215, 14.294036430536547)
                ["highway"]["highway"~"footway|pedestrian|path|living_street"]
                ["foot"!~"no|private"];
                );
                out body;
                >;
                out skel qt;
                """;
        return sendQuery(query);
    }

    private OverpassResponse sendQuery(String query) {
        String url = "https://overpass-api.de/api/interpreter";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity<String> request = new HttpEntity<>(query, headers);

        ResponseEntity<OverpassResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                OverpassResponse.class
        );

        return response.getBody();
    }

}