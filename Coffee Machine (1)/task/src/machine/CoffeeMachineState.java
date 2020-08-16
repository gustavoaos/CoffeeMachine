package machine;

import java.util.Arrays;

import static machine.CoffeeTypes.*;

public enum CoffeeMachineState {
    MAIN_MENU(0) {
        @Override
        public CoffeeMachineState nextState(String action) {
            switch (action) {
                case "buy":
                    return COFFEE_MENU;
                case "fill":
                    return FILLING_RESOURCES;
                case "take":
                    return TAKING_MONEY;
                case "remaining":
                    return REMAINING_RESOURCES;
                default:
                    return EXIT;
            }
        }
    },
    COFFEE_MENU(1) {
        @Override
        public CoffeeMachineState nextState(String action) {
            if (action.equals(CoffeeTypes.ESPRESSO.getValue()) ||
                action.equals(LATTE.getValue()) ||
                action.equals(CAPPUCCINO.getValue())) {
                return PREPARING_COFFEE;
            }

            return MAIN_MENU;
        }
    },
    PREPARING_COFFEE(1) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return MAIN_MENU;
        }
    },
    FILLING_RESOURCES(2) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return FILLING_WATER;
        }
    },
    FILLING_WATER(2) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return FILLING_MILK;
        }
    },
    FILLING_MILK(3) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return FILLING_COFFEE_BEANS;
        }
    },
    FILLING_COFFEE_BEANS(4) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return FILLING_DISPOSABLE_CUPS;
        }
    },
    FILLING_DISPOSABLE_CUPS(5) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return MAIN_MENU;
        }
    },
    TAKING_MONEY(6) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return MAIN_MENU;
        }
    },
    REMAINING_RESOURCES(7) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return MAIN_MENU;
        }
    },
    EXIT(8) {
        @Override
        public CoffeeMachineState nextState(String action) {
            return EXIT;
        }
    };

    private final int value;

    private CoffeeMachineState(int value) {
        this.value = value;
    }

    public abstract CoffeeMachineState nextState(String action);
}
