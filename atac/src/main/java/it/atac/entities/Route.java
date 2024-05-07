package it.atac.entities;

import java.util.List;
import java.util.UUID;

public class Route {
    private UUID id;
    private String startingPoint;
    private String endingPoint;
    private int averageTime;
    private List<VehicleRoute> vehicleRouteList ;

    public Route(String startingPoint, String endingPoint, int averageTime, List<VehicleRoute> vehicleRouteList) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.averageTime = averageTime;
        this.vehicleRouteList = vehicleRouteList;
    }

    public Route() {
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public UUID getId() {
        return id;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public List<VehicleRoute> getVehicleRouteList() {
        return vehicleRouteList;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", averageTime=" + averageTime +
                '}';
    }
}
