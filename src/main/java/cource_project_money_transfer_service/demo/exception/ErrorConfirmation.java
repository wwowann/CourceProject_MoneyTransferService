package cource_project_money_transfer_service.demo.exception;

import java.io.IOException;

public class ErrorConfirmation extends IOException {

    public ErrorConfirmation(String message) {
        super(message);
    }
}
