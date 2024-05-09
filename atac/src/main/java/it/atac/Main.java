package it.atac;

import it.atac.dao.*;
import it.atac.entities.Card;
import it.atac.exceptions.ExpirationDateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.UUID;

public class Main {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("trasporti");
    EntityManager em = emf.createEntityManager();

    BusDAO busDAO = new BusDAO(em);
    CardDAO cardDAO = new CardDAO(em);
    MaintenanceDAO maintenanceDAO = new MaintenanceDAO(em);
    MembershipDAO membershipDAO = new MembershipDAO(em);
    ResellerStoreDAO resellerStoreDAO = new ResellerStoreDAO(em);
    RouteDAO routeDAO = new RouteDAO(em);
    ServiceDAO serviceDAO = new ServiceDAO(em);
    TicketDAO ticketDAO = new TicketDAO(em);
    TramDAO tramDAO = new TramDAO(em);
    UserDAO userDAO = new UserDAO(em);
    VendingMachineDAO vendingMachineDAO = new VendingMachineDAO(em);
    VehicleRouteDAO vehicleRouteDAO = new VehicleRouteDAO(em);

  }
}
