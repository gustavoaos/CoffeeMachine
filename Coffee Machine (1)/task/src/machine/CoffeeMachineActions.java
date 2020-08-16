package machine;

public enum CoffeeMachineActions {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    private final String value;

    CoffeeMachineActions(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
