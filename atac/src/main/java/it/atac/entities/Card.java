package it.atac.entities;

import it.atac.exceptions.ExpirationDateException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "activation_date", nullable = false)
    private LocalDate activationDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate = LocalDate.now();

    @OneToOne(mappedBy = "card")
    private User user;

    @OneToMany(mappedBy = "card")
    private List<Membership> memberships = new ArrayList<>();

    @Column(name = "active_membership")
    private boolean activeMembership;

    public Card(LocalDate activationDate, User user)  {
        try {
            this.activationDate = activationDate;
            this.expirationDate = activationDate.plusYears(1);
            this.isActive = this.checkValidity(this.expirationDate);
            this.user = user;
            this.setActiveMembership();
        } catch (ExpirationDateException e) {
            System.out.println(e.getMessage());
        }
    }

    public Card() {
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) throws ExpirationDateException {
        if (this.expirationDate != null) {
            this.isActive = this.checkValidity(this.expirationDate);
        } else {
            throw new ExpirationDateException("Expiration date cannot be null.");
        }
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate() {
        this.expirationDate = this.activationDate.plusYears(1);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public boolean getActiveMembership() {
        return activeMembership;
    }

    /**
     * Setta a 'true' la variabile 'activeMembership' se trova una membership attiva nella lista di membership associate ad una card, altrimenti 'false'.
     * N.B una card può avere massimo una sola membership attiva alla volta!
     */
    public void setActiveMembership() {
        this.activeMembership = this.memberships.stream().anyMatch(m -> m.isActive());
    }

    public boolean checkValidity(LocalDate expirationDate) throws ExpirationDateException{
        if(expirationDate != null) {
            return LocalDate.now().toEpochDay()<expirationDate.toEpochDay();
        } else {
            throw new ExpirationDateException("Expiration date cannot be null.");
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", activationDate=" + activationDate +
                ", expirationDate=" + expirationDate +
                ", creationDate=" + creationDate +
                ", user=" + user +
                ", activeMembership=" + activeMembership +
                '}';
    }
}
