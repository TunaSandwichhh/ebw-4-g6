package it.atac.dao;

import it.atac.entities.VehicleRoute;
import it.atac.entities.vehicles.Tram;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class VehicleRouteDAO {
    private EntityManager em;

    public VehicleRouteDAO(EntityManager em){
        this.em = em;
    }

    public void save(VehicleRoute vehicleRoute){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(vehicleRoute);
        et.commit();
    }

    public VehicleRoute getById(UUID id){
        return em.find(VehicleRoute.class, id);
    }

    public void delete(VehicleRoute vehicleRoute) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(vehicleRoute);
        et.commit();
    }
}
