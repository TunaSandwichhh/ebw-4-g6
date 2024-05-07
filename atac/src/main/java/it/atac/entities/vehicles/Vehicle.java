package it.atac.entities.vehicles;

import it.atac.entities.vehicleutility.Maintenance;
import it.atac.entities.vehicleutility.Service;
import it.atac.entities.Ticket;
import it.atac.entities.VehicleRoute;

import java.util.List;
import java.util.UUID;

public abstract class Vehicle {

  protected UUID id;
  protected static int maxRoutes;
  protected boolean isWorking;
  protected int totalRoutes;
  protected List<Ticket> tickets;
  protected List<Maintenance> maintenances;
  protected List<Service> services;
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
