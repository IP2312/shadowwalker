package org.example.project.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OverpassServices {
    private final WebClient webClient;

    public OverpassServices(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://overpass-api.de/api/interpreter").build();
    }

    public OverpassResponse getBuildingsNearPoints(){
        String query = """
            [out:json][timeout:25];
            (
              way(around:25, 48.30949476831703, 14.29304903467718)["building"]["height"];
              way(around:25, 48.30949476831703, 14.29304903467718)["building"]["building:levels"];
            );
            out body;
            >;
            out skel qt;
            """;

        return webClient.post()
                .uri("/interpreter")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .bodyValue(query)
                .retrieve()
                .bodyToMono(OverpassResponse.class)
                .block();
    }
}