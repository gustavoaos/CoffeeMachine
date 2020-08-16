package machine;

public interface CoffeeType {

    public CoffeeTypes getCoffeeType();
    public int getWaterNeeded();
    public int getMilkNeeded();
    public int getCoffeeBeansNeeded();
    public int getCost();

    public default int getDisposableCupsNeeded() {
        return 1;
    }

}
