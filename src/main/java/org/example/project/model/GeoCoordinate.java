package org.example.project.model;

public class GeoCoordinate {
    public double lat;
    public double lon;

    public GeoCoordinate(double lat, double lon) {
        setLat(lat);
        setLon(lon);
    }

    public double getLat(){
        return lat;
    }

    public void setLat(double lat){
        this.lat = lat;
    }

    public double getLon(){
        return lon;
    }

    public void setLon(double lon){
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "GeoCoordinate{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
