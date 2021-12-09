package cource_project_money_transfer_service.demo.service;

import cource_project_money_transfer_service.demo.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceConfirOperation {
    private CardRepository cardRepository;

    public String getConfirmOperation(String confirmOperation) {
        return cardRepository.getVerifivationCode(confirmOperation);
    }
}
