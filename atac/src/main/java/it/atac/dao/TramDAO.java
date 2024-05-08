package it.atac.dao;

import it.atac.entities.vehicles.Tram;
import it.atac.entities.vehicleutility.Maintenance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class TramDAO {
    private EntityManager em;

    public TramDAO(EntityManager em){
        this.em = em;
    }

    public void save(Tram tram){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(tram);
        et.commit();
    }

    public Tram getById(UUID id){
        return em.find(Tram.class, id);
    }

    public void delete(Tram tram) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(tram);
        et.commit();
    }
}
