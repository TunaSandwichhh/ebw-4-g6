package it.atac.entities;

import java.util.UUID;

public class VehicleRoute {

    private UUID id;
    private int actualTime;
    private Vehicle vehicle;
    private Route route;

    public VehicleRoute(int actualTime, Vehicle vehicle, Route route) {
        this.actualTime = actualTime;
        this.vehicle = vehicle;
        this.route = route;
    }

    public VehicleRoute(){}

    public UUID getId() {
        return id;
    }

    public int getActualTime() {
        return actualTime;
    }

    public void setActualTime(int actualTime) {
        this.actualTime = actualTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "VehicleRoute{" +
                "id=" + id +
                ", actualTime=" + actualTime +
                ", vehicle=" + vehicle +
                ", route=" + route +
                '}';
    }
}
