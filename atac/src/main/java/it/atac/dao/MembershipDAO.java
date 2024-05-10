package it.atac.dao;

import it.atac.entities.Card;
import it.atac.entities.Membership;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;
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

  public List<Membership> getMembershipsByDate(LocalDate date1, LocalDate date2) {
    Query query = em.createQuery("SELECT m FROM Membership m WHERE m.dateOfIssue >= :date1 AND m.dateOfIssue <= :date2");
    query.setParameter("date1", date1);
    query.setParameter("date2", date2);
    return query.getResultList();
  }

  public boolean checkMembership(UUID cardId) {
    Query query = em.createQuery("SELECT m FROM Membership m WHERE m.card.id = :cardId");
    query.setParameter("cardId", cardId);
    Membership membership = (Membership) query.getSingleResult();

    return membership.isActive();
  }
}
