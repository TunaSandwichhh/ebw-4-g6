package it.atac.entities;

import it.atac.entities.vehicles.Vehicle;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicles_routes")
public class VehicleRoute {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "actual_time", nullable = false)
    private int actualTime;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
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
