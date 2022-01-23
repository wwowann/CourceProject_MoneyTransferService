package cource_project_money_transfer_service.demo.service;

import cource_project_money_transfer_service.demo.handlerexceptions.InvalidRequest;
import cource_project_money_transfer_service.demo.model.CardRequest;
import cource_project_money_transfer_service.demo.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class TransferService {
    private final CardRepository cardRepository;

    public TransferService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    //валидация введенных данных
    public String getValidationTransferCard(CardRequest dataCard) {
        if (dataCard.getCardFromNumber().length() == 12 && dataCard.getCardToNumber().length() == 12)
            throw new InvalidRequest("номер карты должен состоять из 12 цифр");
        if (dataCard.getCardFromNumber().equals(dataCard.getCardToNumber()))
            throw new InvalidRequest("введите другой номер карты получателя они не должны совпадать");
        if (!validateDate(dataCard.getCardFromValidTill()))
            throw new InvalidRequest("срок действия карты истек");
        if (!dataCard.getCardFromNumber().chars().allMatch(Character::isDigit) ||
                !dataCard.getCardToNumber().chars().allMatch(Character::isDigit))
            throw new InvalidRequest("номер карты должен состоять только из цифр");
        if (dataCard.getCardFromCVV().length() != 3 && !dataCard.getCardFromCVV().chars().allMatch(Character::isDigit))
            throw new InvalidRequest("код не состоит из трех знаков или не является числом");
            return cardRepository.getVerificationCode(dataCard);
    }
//валидация введенной даты на карте и даты операции
    private boolean validateDate(String date) {
        int month = Integer.parseInt(date.substring(0, 1));
        int year = Integer.parseInt(date.substring(3, 4));
        Calendar currentDate = Calendar.getInstance();
        return year > currentDate.get(Calendar.YEAR) ||
                (year <= currentDate.get(Calendar.YEAR) && month <= currentDate.get(Calendar.MONTH));
    }

}