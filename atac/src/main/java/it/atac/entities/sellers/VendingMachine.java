package it.atac.entities.sellers;

import it.atac.entities.Membership;
import it.atac.entities.Ticket;

import java.util.List;

public class VendingMachine extends Reseller{
    private boolean isOnline = true;
    private int totalTickets = 150;

    public VendingMachine(List<Ticket> soldTickets, List<Membership> soldMemberships, int totalTickets) {
        super(soldTickets, soldMemberships);
        this.totalTickets = totalTickets;
        this.isOnline = this.checkStatus();
    }

    public VendingMachine() {
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public boolean checkStatus () {
        return this.getTotalTickets()>0;
    }

}
