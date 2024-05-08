package it.atac.dao;

import it.atac.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class UserDAO {

  private EntityManager em;

  public UserDAO(EntityManager em) {
    this.em = em;
  }

  public void save(User user) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.persist(user);
    et.commit();
  }

  public User getById(UUID id) {
    return this.em.find(User.class, id);
  }

  public void delete(User user) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.remove(user);
    et.commit();
  }
}
