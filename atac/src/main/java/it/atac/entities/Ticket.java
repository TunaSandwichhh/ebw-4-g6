package it.atac.entities;

import it.atac.entities.sellers.Reseller;
import it.atac.entities.vehicles.Vehicle;
import it.atac.exceptions.VehicleException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "validation_date")
    private LocalDate validationDate;

    @Column(name = "is_valid")
    private boolean isValid = true;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    public Ticket(LocalDate dateOfIssue, LocalDate validationDate, boolean isValid, Vehicle vehicle, Reseller reseller) {
        this.dateOfIssue = dateOfIssue;
        this.validationDate = validationDate;
        this.isValid = isValid;
        this.vehicle = vehicle;
        this.reseller = reseller;
    }

    public Ticket(){}

    public UUID getId() {
        return id;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Reseller getReseller() {
        return this.reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public void validateTicket(Vehicle vehicle) throws VehicleException {
        if(vehicle != null) {
            this.validationDate = LocalDate.now();
            this.isValid = false;
            this.vehicle = vehicle;
        } else {
            throw new VehicleException("Vehicle cannot be null.");
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", dateOfIssue=" + dateOfIssue +
                ", validationDate=" + validationDate +
                ", isValid=" + isValid +
                ", vehicle=" + vehicle +
                '}';
    }
}
