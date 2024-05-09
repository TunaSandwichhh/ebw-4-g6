package it.atac.dao;

import it.atac.entities.VehicleRoute;
import it.atac.entities.vehicles.Tram;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.UUID;

public class VehicleRouteDAO {
    private EntityManager em;

    public VehicleRouteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(VehicleRoute vehicleRoute) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(vehicleRoute);
        et.commit();
    }

    public VehicleRoute getById(UUID id) {
        return em.find(VehicleRoute.class, id);
    }

    public void delete(VehicleRoute vehicleRoute) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(vehicleRoute);
        et.commit();
    }

    public int countVehicleRoutes(UUID vehicleID, UUID routeID) {
        Query query = em.createQuery("SELECT count(vr) FROM VehicleRoute vr WHERE vr.vehicle = :vehicleID AND vr.route = :routeID");
        query.setParameter("vehicleID", vehicleID);
        query.setParameter("routeID", routeID);
        return Integer.getInteger(query.getSingleResult().toString());
    }

    public int totalTimeVehicleOnRoute(UUID vehicleID, UUID routeID) {
        Query query = em.createQuery("SELECT sum(vr.actualTime) FROM VehicleRoute vr WHERE vr.vehicle = :vehicleID AND vr.route = :routeID");
        query.setParameter("vehicleID", vehicleID);
        query.setParameter("routeID", routeID);
        return Integer.getInteger(query.getSingleResult().toString());
    }
}
