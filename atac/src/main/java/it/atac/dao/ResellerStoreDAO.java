package it.atac.dao;

import it.atac.entities.Membership;
import it.atac.entities.sellers.ResellerStore;
import it.atac.entities.vehicleutility.Maintenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ResellerStoreDAO {
    private EntityManager em;

    public ResellerStoreDAO(EntityManager em){
        this.em = em;
    }

    public void save(ResellerStore resellerStore){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(resellerStore);
        et.commit();
    }

    public ResellerStore getById(UUID id){
        return em.find(ResellerStore.class, id);
    }

    public void delete(ResellerStore resellerStore) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(resellerStore);
        et.commit();
    }

    public List<Membership> getMembershipsByDateAndReseller(LocalDate data1, LocalDate data2, ResellerStore rs) {
        return rs.getSoldMemberships().stream()
                .filter(membership -> membership.getDateOfIssue().toEpochDay() >= data1.toEpochDay() && membership.getDateOfIssue().toEpochDay() <= data2.toEpochDay())
                .toList();
    }

}
