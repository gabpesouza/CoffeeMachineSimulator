import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    public static void main(String[] args) {

        List<Coffee> products = new ArrayList<>();
        products.add(new Coffee(CoffeeType.ESPRESSO, 4, 250, 0, 16));
        products.add(new Coffee(CoffeeType.LATTE, 7, 350, 75, 20));
        products.add(new Coffee(CoffeeType.CAPPUCCINO, 6, 200, 100, 12));

        CoffeeMaker coffeeMaker = new CoffeeMaker(550, 400, 540, 120, 9, products);
        coffeeMaker.takeUserInputOption();
    }
}
