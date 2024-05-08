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

    //veicoli
    Bus b1 = new Bus();
    b1.setWorking(true);

    busDAO.save(b1);

    Service s1 = new Service();
    s1.setVehicle(b1);
    s1.setDataInizio(LocalDate.now());
    serviceDAO.save(s1);

    em.refresh(s1);
    Maintenance ma1 = new Maintenance();
    ma1.setMaintenanceType(MaintenanceType.EXTRA);
    ma1.setStartDate(LocalDate.now());
    ma1.startMaintenance(b1);
    maintenanceDAO.save(ma1);
    Tram tram1 = new Tram();
    tram1.setWorking(true);
//
//
//    //tratta
    Route r1 = new Route();
    r1.setStartingPoint("Via del Corso");
    r1.setEndingPoint("Via Cavour");
    r1.setAverageTime(30);
    routeDAO.save(r1);

    VehicleRoute vr = new VehicleRoute();
    vr.setRoute(r1);
    vr.setVehicle(b1);
    vr.setActualTime(r1.getAverageTime());
    vehicleRouteDAO.save(vr);

//    //rivenditori
    VendingMachine vm1 = new VendingMachine();
    vm1.setOnline(true);

    vendingMachineDAO.save(vm1);
//
//    ResellerStore rs1 = new ResellerStore();
//
//
//    //utenti
    User u1 = new User();
    u1.setFirstName("Mario");
    u1.setLastName("Rossi");
    u1.setDateOfBirth(LocalDate.of(1999, 12, 14));

    userDAO.save(u1);


    Card c1 = new Card();
    c1.setActive(true);
    c1.setActivationDate(LocalDate.of(2023, 7, 15));
    c1.setUser(u1);
    c1.setActiveMembership();
    c1.setExpirationDate();
    cardDAO.save(c1);

    u1.setCard(c1);
    userDAO.save(u1);
//
//

//    //abbonamenti e biglietti
    Membership ms1 = new Membership();
    ms1.setDateOfIssue(LocalDate.of(2024, 5, 1));
    ms1.setMembershipType(MembershipType.MONTHLY);
    ms1.setActive(ms1.checkValidity(ms1.getExpirationDate()));
    ms1.setCard(c1);
    ms1.setReseller(vm1);
    membershipDAO.save(ms1);

    Ticket t1 = new Ticket();
    t1.setDateOfIssue(LocalDate.of(2024, 5,7));
    t1.setReseller(vm1);
    t1.validateTicket(b1);
    ticketDAO.save(t1);

//    System.out.println("Lista biglietti per vending machine");
//    VendingMachine vm2 = vendingMachineDAO.getById(UUID.fromString("99fca705-edd6-458c-b668-6d95327a241b"));
//    vm2.getSoldTickets().forEach(System.out::println);
//
//    System.out.println("Lista biglietti per bus");
//    Bus b2 = busDAO.getById(b1.getId());
//    b2.getTickets().forEach(System.out::println);


  }
}
