package it.atac.dao;

import it.atac.entities.Membership;
import it.atac.entities.sellers.ResellerStore;
import it.atac.entities.sellers.VendingMachine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class VendingMachineDAO {
    private EntityManager em;

    public VendingMachineDAO(EntityManager em){
        this.em = em;
    }

    public void save(VendingMachine vendingMachine){
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(vendingMachine);
        et.commit();
    }

    public VendingMachine getById(UUID id){
        return em.find(VendingMachine.class, id);
    }

    public void delete(VendingMachine vendingMachine) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(vendingMachine);
        et.commit();
    }

    public List<Membership> getMembershipsByDateAndReseller(LocalDate data1, LocalDate data2, VendingMachine vm) {
        return vm.getSoldMemberships().stream()
                .filter(membership -> membership.getDateOfIssue().toEpochDay() >= data1.toEpochDay() && membership.getDateOfIssue().toEpochDay() <= data2.toEpochDay())
                .toList();
    }
}
