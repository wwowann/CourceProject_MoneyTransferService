package cource_project_money_transfer_service.demo.repository;

import cource_project_money_transfer_service.demo.handlerexceptions.InvalidRequest;
import cource_project_money_transfer_service.demo.model.Card;
import cource_project_money_transfer_service.demo.model.CardRequest;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;

@Repository
public class CardRepository {
    public HashMap<String, CardRequest> dataCardMap;// мапа со всеми запросами на перевод денег
    public HashMap<String, Card> card;
    public HashMap<String, CardRequest> verificationDataCard; // мапа с подтвержденными операциями
    public String operationId = createOperationId(); //создается идентификатор операции в случае полной верификации данных карт
    public float amountOperation; // денежная сумма операции с учетом процентов
    public float COMMISSION = 1;

    public CardRepository(HashMap<String, CardRequest> dataCardMap) {
        this.dataCardMap = dataCardMap;
    }

    //проверка существования карт в базе и возврат верификационного кода
    public String getVerificationCode(CardRequest dataRequestCard) {
        card.put("1111111111111111",new Card("1111111111111111", "1223", "031", 50000));
        card.put("2222222222222222",new Card("2222222222222222", "0423", "041", 0));

        if (!card.containsKey(dataRequestCard.getCardToNumber()))
            throw new InvalidRequest("номер карты получателя не существует");
        if (!card.containsKey(dataRequestCard.getCardFromNumber()))
            throw new InvalidRequest("номер карты отправителя не существует");
        float percent = dataRequestCard.getAmount().getValue() * COMMISSION / 100;
        amountOperation = dataRequestCard.getAmount().getValue() + percent;
        if ((amountOperation) > dataCardMap.get(dataRequestCard.getCardFromNumber()).getAmount().getValue())
            throw new InvalidRequest("сумма операции превышает баланс по карте");
        dataRequestCard.setOperationId(operationId);
        verificationDataCard.put(operationId, dataRequestCard);// наполняем мапу с подтвержденными операциями
        dataCardMap.put(dataRequestCard.getCardFromNumber(), dataRequestCard);//
        return operationId;
    }

    //при положительной верификации генерируется Id операции
    private String createOperationId() {
        byte[] array = new byte[6];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    //окончательный перевод денег с карты на карту
    public String moneyTransfer(String operationId) {
        float balanceToCard = card.get(verificationDataCard. //баланс карты на которую переводят
                        get(operationId).getCardToNumber()).
                getBalance() + amountOperation;
        float balanceFromCard = card.get(verificationDataCard.//баланс карты с которой переводят
                        get(operationId).getCardToNumber()).
                getBalance() - amountOperation;
        //записываем балансы по номерам карт
        card.get(verificationDataCard.get(operationId).getCardToNumber()).setBalance(balanceToCard);
        card.get(verificationDataCard.get(operationId).getCardFromNumber()).setBalance(balanceFromCard);
        return "Success confirmation";
    }

}
