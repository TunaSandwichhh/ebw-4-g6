package it.atac.entities;

import it.atac.entities.enums.MembershipType;
import it.atac.entities.sellers.Reseller;
import it.atac.exceptions.ExpirationDateException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "date_of_issue", nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type", nullable = false)
    private MembershipType membershipType;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    @ManyToOne
    @JoinColumn(name = "reseller_id", nullable = false)
    private Reseller reseller;

    public Membership(LocalDate dateOfIssue, MembershipType membershipType, Card card, Reseller reseller) {
        try {
            this.dateOfIssue = dateOfIssue;
            this.membershipType = membershipType;
            this.card = card;
            this.reseller = reseller;
            this.expirationDate = this.membershipType == MembershipType.WEEKLY ? dateOfIssue.plusDays(7) : dateOfIssue.plusDays(30);
            this.isActive = this.checkValidity(expirationDate); //approccio con metodo --> più pulito, "meno" performante
        } catch(ExpirationDateException e) {
            System.out.println(e.getMessage());
        }
    }

    public Membership() {
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
        this.expirationDate = this.membershipType == MembershipType.WEEKLY ? dateOfIssue.plusDays(7) : dateOfIssue.plusDays(30);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public UUID getId() {
        return id;
    }

    /**
     * Creare interfaccia con sto metodo
     * @param expirationDate
     * @return
     */
    public boolean checkValidity(LocalDate expirationDate) throws ExpirationDateException {
        if(expirationDate != null) {
            return LocalDate.now().toEpochDay()<expirationDate.toEpochDay();
        } else {
            throw new ExpirationDateException("Expiration date cannot be null.");
        }
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", dateOfIssue=" + dateOfIssue +
                ", isActive=" + isActive +
                ", expirationDate=" + expirationDate +
                ", membershipType=" + membershipType +
                ", card=" + card +
                ", reseller=" + reseller +
                '}';
    }



}
