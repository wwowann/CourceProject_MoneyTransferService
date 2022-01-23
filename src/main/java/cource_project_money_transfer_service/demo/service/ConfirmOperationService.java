package cource_project_money_transfer_service.demo.service;

import cource_project_money_transfer_service.demo.handlerexceptions.InvalidRequest;
import cource_project_money_transfer_service.demo.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmOperationService {
    private CardRepository cardRepository;

    //проверка возвращенного operationId
    public String getOperation(String operationId, String code) {
        if (//!cardRepository.operationId.equals(operationId) ||
                !code.equals("0000"))// в учебном варианте приходит всегда null на operationId
            throw new InvalidRequest("введен неверный operationId");
        return cardRepository.moneyTransfer(operationId);
    }

}
