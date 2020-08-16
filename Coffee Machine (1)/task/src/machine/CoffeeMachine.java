package machine;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private CoffeeMachineState state;

    public CoffeeMachine() {
        this.setMainState();
    }

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.setMainState();

        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public boolean isOn() {
        return this.state != CoffeeMachineState.EXIT;
    }

    private void setMainState() {
        this.state = CoffeeMachineState.MAIN_MENU;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void execute(String input) {
        this.state = this.state.nextState(input);

        switch (this.state) {
            case MAIN_MENU:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case COFFEE_MENU:
                System.out.println(
                        "What do you want to buy?" +
                                "1 - espresso, " +
                                "2 - latte, " +
                                "3 - cappuccino, " +
                                "back - to main menu:");
                break;
            case PREPARING_COFFEE:
                CoffeeType coffeeType = this.defineCoffeeType(input);
                if (coffeeType != null && hasEnoughResources(coffeeType)) {
                    prepare(coffeeType);
                }
                this.setMainState();
                break;
            case FILLING_RESOURCES:
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case FILLING_WATER:
                this.water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case FILLING_MILK:
                this.milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                break;
            case FILLING_COFFEE_BEANS:
                this.coffeeBeans += Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                break;
            case FILLING_DISPOSABLE_CUPS:
                this.disposableCups += Integer.parseInt(input);
                this.setMainState();
                break;
            case TAKING_MONEY:
                this.taking();
                this.setMainState();
                break;
            case REMAINING_RESOURCES:
                this.printCurrentResources();
                this.setMainState();
                break;
            case EXIT:
            default:
                this.state = CoffeeMachineState.EXIT;
        }
    }

    private CoffeeType defineCoffeeType(String coffeeChosen) {
        CoffeeType coffeeType = null;

        if (CoffeeTypes.ESPRESSO.getValue().equals(coffeeChosen)) {
            coffeeType = new EspressoCoffee();
        } else if (CoffeeTypes.LATTE.getValue().equals(coffeeChosen)) {
            coffeeType = new LatteCoffee();
        } else if (CoffeeTypes.CAPPUCCINO.getValue().equals(coffeeChosen)) {
            coffeeType = new CappuccinoCoffee();
        }

        return coffeeType;
    }

    private boolean hasEnoughResources(CoffeeType coffeeType) {
        if (this.water < coffeeType.getWaterNeeded()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (this.milk < coffeeType.getMilkNeeded()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (this.coffeeBeans < coffeeType.getCoffeeBeansNeeded()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (this.disposableCups < coffeeType.getDisposableCupsNeeded()) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }

    private void prepare(CoffeeType coffeeType) {
        System.out.println("I have enough resources, making you a coffee!");

        this.water -= coffeeType.getWaterNeeded();
        this.milk -= coffeeType.getMilkNeeded();
        this.coffeeBeans -= coffeeType.getCoffeeBeansNeeded();
        this.disposableCups -= coffeeType.getDisposableCupsNeeded();
        this.money += coffeeType.getCost();
    }

    private void taking() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void printCurrentResources() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffeeBeans + " of coffee beans");
        System.out.println(this.disposableCups + " of disposable cups");
        System.out.println(this.money + " of money");
    }

}
