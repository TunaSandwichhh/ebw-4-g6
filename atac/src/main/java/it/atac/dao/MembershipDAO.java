package it.atac.dao;

import it.atac.entities.Membership;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class MembershipDAO {

  private EntityManager em;

  public MembershipDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Membership membership) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.persist(membership);
    et.commit();
  }

  public Membership getById(UUID id) {
    return this.em.find(Membership.class, id);
  }

  public void delete(Membership membership) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.remove(membership);
    et.commit();
  }
}
