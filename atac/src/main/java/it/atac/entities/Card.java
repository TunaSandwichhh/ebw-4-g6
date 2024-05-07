package it.atac.entities;

import javax.persistence.*;
import java.time.LocalDate;
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

    @OneToOne(mappedBy = "card")
    private User user;

    @OneToMany(mappedBy = "card")
    private List<Membership> memberships;

    @Column(name = "active_membership")
    private boolean activeMembership;

    public Card(LocalDate activationDate, User user, List<Membership> memberships, boolean activeMembership) {
        this.activationDate = activationDate;
        this.expirationDate = activationDate.plusYears(1);
        this.isActive = this.checkValidity(this.expirationDate);
        this.user = user;
        this.memberships = memberships;
        this.setActiveMembership();
    }

    public Card() {
    }

    public UUID getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    /**
     * Gestire eccezione in caso expirationDate = null
     * @param active
     */
    public void setActive(boolean active) {
        if (this.expirationDate != null) {
            this.isActive = this.checkValidity(this.expirationDate);
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

    public boolean checkValidity(LocalDate expirationDate){
       return LocalDate.now().toEpochDay()<expirationDate.toEpochDay();
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", activationDate=" + activationDate +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                ", membership=" + activeMembership +
                '}';
    }
}
