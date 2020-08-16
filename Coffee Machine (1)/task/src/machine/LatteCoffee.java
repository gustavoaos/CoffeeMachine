package machine;

public class LatteCoffee implements CoffeeType {

    private final CoffeeTypes coffeeType;
    private final int waterNeeded;
    private final int milkNeeded;
    private final int coffeeBeansNeeded;
    private final int cost;

    public LatteCoffee() {
        this.coffeeType = CoffeeTypes.LATTE;
        this.waterNeeded = 350;
        this.milkNeeded = 75;
        this.coffeeBeansNeeded = 20;
        this.cost = 7;
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