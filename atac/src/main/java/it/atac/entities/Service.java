package it.atac.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Service {

    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Vehicle vehicle;

    public Service(LocalDate startDate, LocalDate endDate, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicle = vehicle;
    }
    public Service(){}

    public UUID getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return startDate;
    }

    public void setDataInizio(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDataFine() {
        return endDate;
    }

    public void setDataFine(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", vehicle=" + vehicle +
                '}';
    }
}
