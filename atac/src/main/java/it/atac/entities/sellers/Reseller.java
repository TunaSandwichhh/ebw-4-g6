package it.atac.entities.sellers;

import it.atac.entities.Membership;
import it.atac.entities.Ticket;

import java.util.List;
import java.util.UUID;

public abstract class Reseller {
    protected UUID id;
    protected List<Ticket> soldTickets;
    protected List<Membership> soldMemberships;

    public Reseller(List<Ticket> soldTickets, List<Membership> soldMemberships) {
        this.soldTickets = soldTickets;
        this.soldMemberships = soldMemberships;
    }

    public Reseller() {
    }

    public UUID getId() {
        return id;
    }

    public List<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public List<Membership> getSoldMemberships() {
        return soldMemberships;
    }

    @Override
    public String toString() {
        return "Reseller{" +
                "id=" + id +
                '}';
    }
}
