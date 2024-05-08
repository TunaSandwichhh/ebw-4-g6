package it.atac.dao;

import it.atac.entities.vehicles.Bus;
import it.atac.entities.vehicleutility.Maintenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class BusDAO {
    private EntityManager em;

    public BusDAO(EntityManager em){
        this.em = em;
    }

    public void save(Bus bus){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(bus);
        et.commit();
    }

    public Bus getById(UUID id){
        return em.find(Bus.class, id);
    }

    public void delete(Bus bus) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(bus);
        et.commit();
    }
}
