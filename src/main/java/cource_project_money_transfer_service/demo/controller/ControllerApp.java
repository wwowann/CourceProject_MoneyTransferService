package cource_project_money_transfer_service.demo.controller;

import cource_project_money_transfer_service.demo.model.DataCard;
import cource_project_money_transfer_service.demo.service.TransferService;
import cource_project_money_transfer_service.demo.service.TransferServiceConfirOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class ControllerApp {
    private final TransferService transferService;
    private final TransferServiceConfirOperation transferServiceConfirOperation;

    public ControllerApp(TransferService transferService, TransferServiceConfirOperation transferServiceConfirOperation) {
        this.transferService = transferService;
        this.transferServiceConfirOperation = transferServiceConfirOperation;
    }

    @PostMapping("/{dataCard}")
    public String getValidateCard(@CardValidator DataCard dataCard) {

        return transferService.getValidateCard(dataCard);
    }

    @PostMapping("/confirmOperation")
    public String getDateConfirm(String operationId) {
        return transferServiceConfirOperation.getConfirmOperation(operationId);
    }

}
