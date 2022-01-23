package cource_project_money_transfer_service.demo.model;

public class AmountObject {
    private int value;
    private String currency;

    public AmountObject(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String current) {
        this.currency = currency;
    }


}
