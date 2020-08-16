package machine;

public class EspressoCoffee implements CoffeeType {

    private final CoffeeTypes coffeeType;
    private final int waterNeeded;
    private final int milkNeeded;
    private final int coffeeBeansNeeded;
    private final int cost;

    public EspressoCoffee() {
        this.coffeeType = CoffeeTypes.ESPRESSO;
        this.waterNeeded = 250;
        this.milkNeeded = 0;
        this.coffeeBeansNeeded = 16;
        this.cost = 4;
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
