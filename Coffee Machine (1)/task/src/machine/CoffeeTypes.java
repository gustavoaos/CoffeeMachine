package machine;

public enum CoffeeTypes {
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3");

    private final String value;

    CoffeeTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
