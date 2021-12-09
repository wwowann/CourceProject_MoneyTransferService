package cource_project_money_transfer_service.demo.model;

import java.util.Objects;

public class DataCard {
    private final String cardFromNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;
    private final String cardToNumber;
    private AmountObject amount;
    private final String verificationCode;


    public DataCard(String cardFromNumber, String cardFromValidTill, String cardFromCVV,
                    String cardToNumber, AmountObject amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        verificationCode = "0000";

    }

    public String getVerificationCode(){
        return verificationCode;
    }
    public String getCardToNumber() {
        return cardToNumber;
    }
    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public AmountObject getAmount() {
        return amount;
    }

    public void setAmount(AmountObject mount) {
        this.amount = amount;
    }

      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataCard)) return false;
        DataCard dataCard = (DataCard) o;
        return Objects.equals(cardFromNumber, dataCard.cardFromNumber) && cardFromValidTill.equals(dataCard.cardFromValidTill) && cardFromCVV.equals(dataCard.cardFromCVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFromNumber, cardFromValidTill, cardFromCVV);
    }
}
