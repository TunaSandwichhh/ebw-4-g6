package it.atac.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket {

    private UUID id;
    private LocalDate dateOfIssue;
    private LocalDate validationDate;
    private boolean isValid;
    private Vehicle vehicle;

    public Ticket(LocalDate dateOfIssue, LocalDate validationDate, boolean isValid, Vehicle vehicle) {
        this.dateOfIssue = dateOfIssue;
        this.validationDate = validationDate;
        this.isValid = isValid;
        this.vehicle = vehicle;
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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
