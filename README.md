# Sistema Trasporti

## Introduzione
Questo progetto rappresenta un sistema di trasporti pubblici sviluppato in **Java** utilizzando **Maven**
come strumento di gestione delle dipendenze e **JPA** (Java Persistence API) con **Hibernate** come 
provider per la persistenza dei dati. Il sistema si basa su un database **PostgreSQL** per memorizzare 
le informazioni relative a carte, abbonamenti, percorsi, biglietti, utenti e altri enti correlati.

## Installazione
Per utilizzare questo progetto, è necessario installare le seguenti dipendenze nel file **pom.xml**
del progetto Maven:

```html
<!-- Dipendenza PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>

<!-- Dipendenza Hibernate Entity Manager -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>5.6.15.Final</version>
</dependency>
```

## Struttura
Il progetto è suddiviso nei seguenti pacchetti e classi:

### it.atac
Contenente la classe Main

### it.atac.entities
- `Card`: Rappresenta una tessera necessaria per avere un abbonamento.
- `Membership`: Rappresenta un abbonamento.
- `Route`: Rappresenta un percorso di trasporto.
- `Ticket`: Rappresenta un biglietto.
- `User`: Rappresenta un utente del sistema.
- `VehicleRoute`: Rappresenta una relazione tra veicolo e percorso.
- `Maintenance`: Rappresenta una manutenzione.
- `Service`: Rappresenta un servizio.
- `Vehicle`: Classe astratta che rappresenta un veicolo.
- `Bus`: Rappresenta un autobus, sottoclasse di `Vehicle`.
- `Tram`: Rappresenta un tram, sottoclasse di `Vehicle`.
- `Reseller`: Classe astratta che rappresenta un rivenditore.
- `ResellerStore`: Rappresenta un negozio di rivendita, sottoclasse di `Reseller`.
- `VendingMachine`: Rappresenta una macchina distributrice, sottoclasse di `Reseller`.

### it.atac.dao
Questo pacchetto contiene classi _DAO_ per ciascuna entità del sistema per la gestione delle
operazioni di persistenza nel database.

Le classi _DAO_ presenti nel pacchetto dao sono responsabili della gestione delle operazioni
_**CRUD**_ _(Create, Read, Update, Delete)_ per ciascuna entità del sistema nel database **PostgreSQL**.

### it.atac.exceptions
Contiene alcune classi di eccezioni personalizzate per gestire situazioni eccezionali 
all'interno del sistema.

## Autori

[Gabriele Scognamiglio](https://github.com/GabScognamiglio)</br>
[Fabio Gallingani](https://github.com/fabiogalli95)</br>
[Clarissa Piovesan](https://github.com/clarissa1110)</br>
[Elias Pinna](https://github.com/PinnaElias)</br>
[Paola Del Vecchio](https://github.com/smoulderpipe)</br>
[Davide Faggionato](https://github.com/TunaSandwichhh)</br>