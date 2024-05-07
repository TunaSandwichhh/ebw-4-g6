package it.atac.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Card {
    private UUID id;
    private boolean isActive;
    private LocalDate activationDate;
    private LocalDate expirationDate;
    private User user;
    private List<Membership> memberships;
    private Membership membership;

    public Card(LocalDate activationDate, User user, List<Membership> memberships, Membership membership) {
        this.activationDate = activationDate;
        this.expirationDate = activationDate.plusYears(1);
        this.isActive = this.checkValidity(this.expirationDate);
        this.user = user;
        this.memberships = memberships;
        this.membership = membership;
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

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
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
                ", membership=" + membership +
                '}';
    }
}
