package it.atac;

import it.atac.dao.*;
import it.atac.entities.*;
import it.atac.entities.enums.MaintenanceType;
import it.atac.entities.enums.MembershipType;
import it.atac.entities.sellers.ResellerStore;
import it.atac.entities.sellers.VendingMachine;
import it.atac.entities.vehicles.Bus;
import it.atac.entities.vehicles.Tram;
import it.atac.entities.vehicleutility.Maintenance;
import it.atac.entities.vehicleutility.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
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
