package cource_project_money_transfer_service.demo.controller;

import cource_project_money_transfer_service.demo.model.CardRequest;
import cource_project_money_transfer_service.demo.service.ConfirmOperationService;
import cource_project_money_transfer_service.demo.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class ControllerApp {
    private final TransferService transferService;
    private final ConfirmOperationService confirmOperationService;

    public ControllerApp(TransferService transferService, ConfirmOperationService confirmOperationService) {
        this.transferService = transferService;
        this.confirmOperationService = confirmOperationService;
    }

    @PostMapping("/transfer")
    public String getValidationTransferCard(@RequestBody CardRequest cardRequest) {
        return transferService.getValidationTransferCard(cardRequest);
    }

    @PostMapping("/confirmOperation")
    public String getDateConfirm(@RequestBody String operationId, String code) {
        return confirmOperationService.getOperation(operationId, code);
    }


}
