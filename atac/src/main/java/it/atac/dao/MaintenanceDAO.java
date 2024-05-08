package it.atac.dao;

import it.atac.entities.vehicleutility.Maintenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class MaintenanceDAO {
    private EntityManager em;

    public MaintenanceDAO(EntityManager em){
        this.em = em;
    }

    public void save(Maintenance maintenance){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(maintenance);
        et.commit();
    }

    public Maintenance getById(UUID id){
        return em.find(Maintenance.class, id);
    }

    public void delete(Maintenance maintenance) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(maintenance);
        et.commit();
    }
}
