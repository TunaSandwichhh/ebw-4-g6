package it.atac.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "starting_point", nullable = false)
    private String startingPoint;

    @Column(name = "ending_point", nullable = false)
    private String endingPoint;

    @Column(name = "average_time", nullable = false)
    private int averageTime;

    @OneToMany(mappedBy = "route")
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
