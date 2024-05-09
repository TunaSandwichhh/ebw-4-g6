package it.atac.entities.sellers;

import it.atac.entities.Membership;
import it.atac.entities.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Reseller {

    @Id
    @GeneratedValue
    protected UUID id;

    @OneToMany(mappedBy = "reseller")
    @Column(name = "sold_tickets")
    protected List<Ticket> soldTickets;

    @OneToMany(mappedBy = "reseller")
    @Column(name = "sold_memberships")
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
