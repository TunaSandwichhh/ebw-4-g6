package it.atac.dao;

import it.atac.entities.sellers.ResellerStore;
import it.atac.entities.vehicleutility.Maintenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
}
