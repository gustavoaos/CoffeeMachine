package machine;

public class CappuccinoCoffee implements CoffeeType {

    private final CoffeeTypes coffeeType;
    private final int waterNeeded;
    private final int milkNeeded;
    private final int coffeeBeansNeeded;
    private final int cost;

    public CappuccinoCoffee() {
        this.coffeeType = CoffeeTypes.CAPPUCCINO;
        this.waterNeeded = 200;
        this.milkNeeded = 100;
        this.coffeeBeansNeeded = 12;
        this.cost = 6;
    }

    @Override
    public CoffeeTypes getCoffeeType() {
        return this.coffeeType;
    }

    @Override
    public int getWaterNeeded() {
        return this.waterNeeded;
    }

    @Override
    public int getMilkNeeded() {
        return this.milkNeeded;
    }

    @Override
    public int getCoffeeBeansNeeded() {
        return this.coffeeBeansNeeded;
    }

    @Override
    public int getCost() {
        return this.cost;
    }
}
