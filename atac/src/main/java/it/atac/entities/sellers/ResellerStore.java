package it.atac.entities.sellers;

import it.atac.entities.Membership;
import it.atac.entities.Ticket;

import java.util.List;

public class ResellerStore extends Reseller{
    private String storeName;

    public ResellerStore(List<Ticket> soldTickets, List<Membership> soldMemberships, String storeName) {
        super(soldTickets, soldMemberships);
        this.storeName = storeName;
    }

    public ResellerStore() {
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "ResellerStore{" +
                "storeName='" + storeName + '\'' +
                ", id=" + id +
                '}';
    }
}
