package it.atac.entities.vehicles;

import it.atac.entities.vehicleutility.Maintenance;
import it.atac.entities.vehicleutility.Service;
import it.atac.entities.Ticket;
import it.atac.entities.VehicleRoute;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

  @Id
  @GeneratedValue
  protected UUID id;

  @Column(name = "max_routes", nullable = false)
  protected static int maxRoutes;

  @Column(name = "is_working")
  protected boolean isWorking;

  @Column(name = "total_routes", nullable = false)
  protected int totalRoutes = 0;

  @OneToMany(mappedBy = "vehicle")
  protected List<Ticket> tickets;

  @OneToMany(mappedBy = "vehicle")
  protected List<Maintenance> maintenances;

  @OneToMany(mappedBy = "vehicle")
  protected List<Service> services;

  @OneToMany(mappedBy = "vehicle")
  protected List<VehicleRoute> vehicleRouteList ;

  public Vehicle(boolean isWorking, int totalRoutes) {
    this.isWorking = isWorking;
    this.totalRoutes = totalRoutes;
  }

  public Vehicle() {}

  public List<VehicleRoute> getVehicleRouteList() {
    return vehicleRouteList;
  }

  public UUID getId() {
    return id;
  }

  public static int getMaxRoutes() {
    return maxRoutes;
  }

  public static void setMaxRoutes(int maxRoutes) {
    Vehicle.maxRoutes = maxRoutes;
  }

  public boolean isWorking() {
    return isWorking;
  }

  public void setWorking(boolean working) {
    isWorking = working;
  }

  public int getTotalRoutes() {
    return totalRoutes;
  }

  public void setTotalRoutes(int totalRoutes) {
    this.totalRoutes = totalRoutes;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public List<Maintenance> getMaintenances() {
    return maintenances;
  }

  public List<Service> getServices() {
    return services;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
            "id=" + id +
            ", isWorking=" + isWorking +
            ", totalRoutes=" + totalRoutes +
            ", tickets=" + tickets +
            '}';
  }
}
