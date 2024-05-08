package it.atac.dao;

import it.atac.entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class TicketDAO {

  private EntityManager em;

  public TicketDAO(EntityManager em) {
    this.em = em;
  }

  public void save(Ticket ticket) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.persist(ticket);
    et.commit();
  }

  public Ticket getById(UUID id) {
    return this.em.find(Ticket.class, id);
  }

  public void delete(Ticket ticket) {
    EntityTransaction et = this.em.getTransaction();
    et.begin();
    em.remove(ticket);
    et.commit();
  }
}
