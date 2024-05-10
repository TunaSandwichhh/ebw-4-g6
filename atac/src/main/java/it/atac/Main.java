package it.atac;

import it.atac.dao.*;
import it.atac.entities.*;
import it.atac.entities.enums.MaintenanceType;
import it.atac.entities.enums.MembershipType;
import it.atac.entities.sellers.VendingMachine;
import it.atac.entities.vehicles.Bus;
import it.atac.entities.vehicleutility.Maintenance;
import it.atac.entities.vehicleutility.Service;
import it.atac.exceptions.DateOfBirthException;
import it.atac.exceptions.ExpirationDateException;
import it.atac.exceptions.VehicleException;

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

//        Bus b1 = new Bus();
//        b1.setWorking(true);
//
//        Bus b2 = new Bus();
//        b2.setWorking(true);
//
//        Bus b3 = new Bus();
//        b3.setWorking(true);
//
//        busDAO.save(b1);
//        busDAO.save(b2);
//        busDAO.save(b3);
//
//        User u1 = new User();
//        u1.setFirstName("Gabriele");
//        u1.setLastName("Scognamiglio");
//        try {
//            u1.setDateOfBirth(LocalDate.of(1995, 2, 16));
//        } catch (DateOfBirthException e) {
//            System.out.println(e.getMessage());
//        }
//
//        userDAO.save(u1);
//
//        VendingMachine vm1 = new VendingMachine();
//        vm1.setOnline(true);
//
//        vendingMachineDAO.save(vm1);
//
//        Card c1 = new Card();
//        c1.setActivationDate(LocalDate.now());
//        c1.setExpirationDate();
//        c1.setUser(u1);
//        c1.setActiveMembership();
//
//        cardDAO.save(c1);
//
//        Membership ms = new Membership();
//        ms.setDateOfIssue(LocalDate.now());
//        ms.setCard(c1);
//        ms.setMembershipType(MembershipType.WEEKLY);
//        ms.setReseller(vm1);
//        try {
//            ms.setActive(ms.checkValidity(ms.getExpirationDate()));
//        } catch (ExpirationDateException e) {
//            System.out.println(e.getMessage());
//        }
//
//        membershipDAO.save(ms);
//
//        Route route1 = new Route();
//        route1.setAverageTime(33);
//        route1.setStartingPoint("Via Caltanissetta");
//        route1.setEndingPoint("Piazza Grassi");
//
//        routeDAO.save(route1);
//
//        VehicleRoute viaggio1 = new VehicleRoute();
//        viaggio1.setActualTime(28);
//        viaggio1.setRoute(route1);
//        viaggio1.setVehicle(b2);

//        VehicleRoute viaggio2 = new VehicleRoute();
//        viaggio2.setActualTime(108);
//        viaggio2.setRoute(routeDAO.getById(UUID.fromString("5363cd4d-4545-4254-a7d5-43434293f867")));
//        viaggio2.setVehicle(busDAO.getById(UUID.fromString("3a72abe1-026d-4fa2-ad67-11b8b7fcb8c6")));
//        vehicleRouteDAO.save(viaggio2);
//
//        vehicleRouteDAO.save(viaggio1);
//
//        Ticket t1 = new Ticket();
//        t1.setReseller(vm1);
//        t1.setDateOfIssue(LocalDate.now());
//        try {
//            t1.validateTicket(b2);
//        } catch (VehicleException e) {
//            System.out.println(e.getMessage());
//        }
//
//        ticketDAO.save(t1);

//        Service servizio = new Service();
//        servizio.startService(busDAO.getById(UUID.fromString("847edadc-134a-42cb-8c0b-e7dcc1bf8c83")));
//
//        serviceDAO.save(servizio);

//        Maintenance m1 = new Maintenance();
//        m1.setDescription("Cambio olio e filtri");
//        m1.setMaintenanceType(MaintenanceType.ORDINARY);
//        m1.startMaintenance(busDAO.getById(UUID.fromString("847edadc-134a-42cb-8c0b-e7dcc1bf8c83")));
//
//        maintenanceDAO.save(m1);

//        //1)PRENDERE LE MANUTENZIONI DI UN BUS
//        busDAO.getMaintenancesByBus(busDAO.getById(UUID.fromString("847edadc-134a-42cb-8c0b-e7dcc1bf8c83")));
//        //2)PRENDERE PERIODI DI SERVIZIO DI UN BUS
//        busDAO.getServicesByBus(busDAO.getById(UUID.fromString("847edadc-134a-42cb-8c0b-e7dcc1bf8c83")));
//        //3)LISTA BIGLIETTI VIDIMATI PER MEZZO
//        busDAO.validatedTicketsByVehicle(busDAO.getById(UUID.fromString("847edadc-134a-42cb-8c0b-e7dcc1bf8c83")));
//
//

//        User u2 = new User();
//        u2.setFirstName("Mario");
//        u2.setLastName("Panfadelli");
//        try {
//            u2.setDateOfBirth(LocalDate.of(1952,1,1));
//        } catch (DateOfBirthException e) {
//            System.out.println(e.getMessage());
//        }
//
//        userDAO.save(u2);
//
//        Card c2 = new Card();
//        c2.setActivationDate(LocalDate.now());
//        c2.setExpirationDate();
//        c2.setActiveMembership();
//        try {
//            c2.setActive(true);
//        } catch (ExpirationDateException e) {
//            System.out.println(e.getMessage());
//        }
//
//        cardDAO.save(c2);
//
//        c2.setUser(u2);
//        u2.setCard(c2);
//
//        cardDAO.save(c2);
//        userDAO.save(u2);
//
//
//
//        Membership ms2 = new Membership();
//        ms2.setReseller(vendingMachineDAO.getById(UUID.fromString("0faf9c88-0aaf-4b9d-bf3e-718a5306212d")));
//        ms2.setCard(c2);
//        ms2.setDateOfIssue(LocalDate.of(2024, 5,5));
//        ms2.setMembershipType(MembershipType.MONTHLY);
//        try {
//            ms2.setActive(ms2.checkValidity(ms2.getExpirationDate()));
//        } catch (ExpirationDateException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//
//        cardDAO.save(c2);
//        membershipDAO.save(ms2);


//      4)CONTROLLARE VALIDITA' ABBONAMENTO DATA UNA CARD
//        System.out.println( membershipDAO.checkMembership(UUID.fromString("5ea7db3d-1555-4d94-83c2-091a5a1a731a")));

//        //5)AGGIORNA TEMPO MEDIO
//        int nuovotempoMEdio = routeDAO.calculateAverageTimeByRoute(routeDAO.getById(UUID.fromString("5363cd4d-4545-4254-a7d5-43434293f867")));
//        Route r1 = routeDAO.getById(UUID.fromString("5363cd4d-4545-4254-a7d5-43434293f867"));
//        r1.setAverageTime(nuovotempoMEdio);
//        routeDAO.save(r1);

//        //6)PRENDERE LISTA ABBONAMENTI VENDUTI PER DATA E RIVENDITORE
//        VendingMachine vmProva = vendingMachineDAO.getById(UUID.fromString("0faf9c88-0aaf-4b9d-bf3e-718a5306212d"));
//        vendingMachineDAO.getMembershipsByDateAndReseller(LocalDate.of(2024,1,1), LocalDate.of(2024,12,31), vmProva).forEach(System.out::println);

//       7) LISTA BIGLIETTI VIDIMATI PER DATA
//        ticketDAO.validatedTicketsByDates(LocalDate.of(2024,1,1), LocalDate.of(2024,12,31)).
//                forEach(System.out::println);

        //8)TOTALE VIAGGI DATI UN MEZZO E UNA TRATTA
//        System.out.println(vehicleRouteDAO.countVehicleRoutes(UUID.fromString("3a72abe1-026d-4fa2-ad67-11b8b7fcb8c6"), UUID.fromString("5363cd4d-4545-4254-a7d5-43434293f867")));

        //9)SOMMA DEI TEMPI EFFETTIVI DI VIAGGI DI UN VEICOLO SU UNA TRATTA
//        System.out.println(vehicleRouteDAO.totalTimeVehicleOnRoute(UUID.fromString("3a72abe1-026d-4fa2-ad67-11b8b7fcb8c6"), UUID.fromString("5363cd4d-4545-4254-a7d5-43434293f867")));

        //10)PRENDERE UNA LISTA DI ABBONAMENTI DATE DUE DATE
       // membershipDAO.getMembershipsByDate(LocalDate.of(2024,1,1), LocalDate.of(2024,12,31)).forEach(System.out::println);

    }
}
