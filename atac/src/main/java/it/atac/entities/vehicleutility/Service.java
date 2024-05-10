package it.atac.entities.vehicleutility;

import it.atac.entities.vehicles.Vehicle;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Service(LocalDate startDate, LocalDate endDate, Vehicle vehicle) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicle = vehicle;
    }

    public Service() {
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void startService(Vehicle vehicle) {
        if (vehicle != null) {
            this.vehicle = vehicle;
            this.startDate = LocalDate.now();
        }

        List<Maintenance> maintenanceList = this.vehicle.getMaintenances()
                .stream()
                .filter(maintenance -> !maintenance.getVehicle().isWorking())
                .toList();

        if (!maintenanceList.isEmpty()) {
            maintenanceList.getFirst().setEndDate(LocalDate.now());
            this.vehicle.setWorking(true);
        }


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
