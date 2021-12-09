package cource_project_money_transfer_service.demo.service;

import cource_project_money_transfer_service.demo.model.DataCard;
import cource_project_money_transfer_service.demo.repository.CardRepository;
import cource_project_money_transfer_service.demo.handlerexceptions.InvalidRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransferService {
    private final CardRepository cardRepository;

    public TransferService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String getValidateCard(DataCard dataCard) {
        if (!(cardNumber(dataCard) && cardCVV(dataCard) &&
                cardDateTill(dataCard) && cardNumberTo(dataCard) &&
                amountValueType(dataCard))) {
            throw new InvalidRequest("Error input data");
        }
        return cardRepository.getDataCard(dataCard);
    }

    private boolean cardNumber(DataCard dataCard) {//проверка на то, что номер карты является числом и его длина 12 знаков
        return dataCard.getCardFromNumber().length() == 12
                && dataCard.getCardFromNumber().chars().allMatch(Character::isDigit);
    }

    private boolean cardCVV(DataCard dataCard) {//проверка валидности спецкода карты
        return dataCard.getCardFromNumber().length() == 3
                && dataCard.getCardFromCVV().chars().allMatch(Character::isDigit);
    }

    private boolean cardDateTill(DataCard dataCard) {//проверяем валидность даты карты
        int month = 0;
        int year = 0;
        Date date = new Date();//текущая дата
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (dataCard.getCardFromValidTill().chars().allMatch(Character::isDigit)
                && dataCard.getCardFromValidTill().length() == 4) {
            month = Integer.parseInt(dataCard.getCardFromValidTill().substring(0, 1));
            year = Integer.parseInt(dataCard.getCardFromValidTill().substring(2, 3));
        }
        return cal.get(Calendar.YEAR) > year || cal.get(Calendar.MONTH) <= month;
    }

    private boolean cardNumberTo(DataCard dataCard) {//проверка на то, что номер карты назначения платежа является числом и его длина 12 знаков
        return dataCard.getCardToNumber().length() == 12
                && dataCard.getCardToNumber().chars().allMatch(Character::isDigit);
    }

    private boolean amountValueType(DataCard dataCard) {
        return dataCard.getCardToNumber().chars().allMatch(Character::isDigit);
    }
}