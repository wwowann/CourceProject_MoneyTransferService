package cource_project_money_transfer_service.demo.model;

public class Card {
    private final String cardNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;
    private float balance;

    public Card(String cardNumber, String cardFromValidTill, String cardFromCVV, float balance) {
        this.cardNumber = cardNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
