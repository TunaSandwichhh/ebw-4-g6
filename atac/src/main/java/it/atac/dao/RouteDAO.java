package it.atac.dao;

import it.atac.entities.Route;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class RouteDAO {

  private EntityManager em;

  public RouteDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Route route) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.persist(route);
    et.commit();
  }

  public Route getById(UUID id) {
    return this.em.find(Route.class, id);
  }

  public void delete(Route route) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.remove(route);
    et.commit();
  }
}
