package it.atac.entities;

import it.atac.entities.enums.MembershipType;
import it.atac.entities.sellers.Reseller;

import java.time.LocalDate;
import java.util.UUID;

public class Membership {
    private UUID id;
    private LocalDate dateOfIssue;
    private boolean isActive;
    private LocalDate expirationDate;
    private MembershipType membershipType;
    private Card card;
    private Reseller reseller;

    public Membership(LocalDate dateOfIssue, MembershipType membershipType, Card card, Reseller reseller) {
        this.dateOfIssue = dateOfIssue;
        this.membershipType = membershipType;
        this.card = card;
        this.reseller = reseller;
        this.expirationDate = this.membershipType == MembershipType.WEEKLY ? dateOfIssue.plusDays(7) : dateOfIssue.plusDays(30);
        this.isActive = this.checkValidity(expirationDate); //approccio con metodo --> più pulito, "meno" performante
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

    /**
     * Creare interfaccia con sto metodo
     * @param expirationDate
     * @return
     */
    public boolean checkValidity(LocalDate expirationDate){
        return LocalDate.now().toEpochDay()<expirationDate.toEpochDay();
    }

}
