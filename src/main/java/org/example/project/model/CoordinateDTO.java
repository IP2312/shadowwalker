package org.example.project.model;

public class CoordinateDTO {
    public double lat;
    public double lon;

    public CoordinateDTO(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "CoordinateDTO{" +
                "lat=" + lat + "," + lon +
                '}';
    }
}
