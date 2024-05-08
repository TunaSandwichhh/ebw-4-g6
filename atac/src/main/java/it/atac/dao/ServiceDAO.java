package it.atac.dao;

import it.atac.entities.vehicleutility.Maintenance;
import it.atac.entities.vehicleutility.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class ServiceDAO {
    private EntityManager em;

    public ServiceDAO(EntityManager em){
        this.em = em;
    }

    public void save(Service service){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(service);
        et.commit();
    }

    public Service getById(UUID id){
        return em.find(Service.class, id);
    }

    public void delete(Service service) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(service);
        et.commit();
    }
}
