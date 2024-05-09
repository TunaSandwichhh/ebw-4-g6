package it.atac.dao;

import it.atac.entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
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

  public List<Ticket> validatedTicketsByDates(LocalDate startDate, LocalDate endDate) {
    Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.validationDate >= :startDate AND t.validationDate <= :endDate");
    query.setParameter("startDate", startDate);
    query.setParameter("endDate", endDate);
    return query.getResultList();
  }
}
