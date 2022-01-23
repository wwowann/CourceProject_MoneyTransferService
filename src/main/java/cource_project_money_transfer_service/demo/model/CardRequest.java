package cource_project_money_transfer_service.demo.model;

import java.util.Objects;

public class CardRequest {
    private final String cardFromNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;
    private final String cardToNumber;
    private AmountObject amount;
    private String operationId;

    public CardRequest (String cardFromNumber, String cardFromValidTill, String cardFromCVV,
                    String cardToNumber, AmountObject amount, String operationId) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        this.operationId = operationId;

    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
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
        if (!(o instanceof CardRequest)) return false;
        CardRequest cardRepository = (CardRequest) o;
        return Objects.equals(cardFromNumber, cardRepository.cardFromNumber) &&
                cardFromValidTill.equals(cardRepository.cardFromValidTill) && cardFromCVV.equals(cardRepository.cardFromCVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFromNumber, cardFromValidTill, cardFromCVV);
    }
}
