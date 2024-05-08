package it.atac.dao;

import it.atac.entities.Card;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.UUID;

public class CardDAO {
    private EntityManager em;

    public CardDAO(EntityManager em){
        this.em = em;
    }

    public void save(Card card){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(card);
        et.commit();
    }

    public Card getById(UUID id){
        return em.find(Card.class, id);
    }

    public void delete(Card card){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(card);
        et.commit();
    }
}
