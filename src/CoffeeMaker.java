import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMaker {

    private int money;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private List<Coffee> products = new ArrayList<>();
    private final static Scanner scanner = new Scanner(System.in);

    public CoffeeMaker(int money, int water, int milk, int coffeeBeans, int disposableCups, List<Coffee> products) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.products = products;
    }

    public void showSupply() {
        StringBuilder builder = new StringBuilder();
        builder.append("The coffee machine has:").append("\n")
                .append(water).append(" ml of water").append("\n")
                .append(milk).append(" ml of milk").append("\n")
                .append(coffeeBeans).append(" g of coffee beans").append("\n")
                .append(disposableCups).append(" disposable cups").append("\n")
                .append("$").append(money).append(" of money").append("\n");

        displayMessage(builder.toString());
    }

    public void takeUserInputOption() {

        String action = "start";
        while(!action.equals("exit")){
            displayMessage("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "fill":
                    fill();
                    break;
                case "buy":
                    buy();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showSupply();
                    break;
            }
        }
    }

    private void takeMoney(){
        displayMessage("I gave you $ " + this.money);
        setMoney(0);
    }

    private void fill(){
        displayMessage("Write how many ml of water you want to add: ");
        int waterAmount = scanner.nextInt();
        this.water += waterAmount;

        displayMessage("Write how many ml of milk you want to add: ");
        int milkAmount = scanner.nextInt();
        this.milk += milkAmount;

        displayMessage("Write how many grams of coffee beans you want to add: ");
        int coffeeBeansAmount = scanner.nextInt();
        this.coffeeBeans += coffeeBeansAmount;

        displayMessage("Write how many disposable cups you want to add: ");
        int disposableCupsAmount = scanner.nextInt();
        this.disposableCups += disposableCupsAmount;

        displayMessage("");
    }

    private void buy(){
        displayMessage("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String selected = scanner.next();

        if(selected.equals("back")){
            return;
        }

        Coffee coffee = getCoffeeByType(Integer.parseInt(selected));
        boolean hasEnoughSupply = checkSupply(coffee);

        if (hasEnoughSupply) {
            this.displayMessage("I have enough resources, making you a coffee!");
            this.processCoffee(coffee);
        } else {
            displayMissingSupply(coffee);
        }

    }

    private void displayMissingSupply(Coffee coffee) {
        String message = "Sorry, not enough ";
        if (this.water < coffee.getWaterNeeded()) {
            message += "water!";
        } else if (this.disposableCups <= 0) {
            message += "cups!";
        } else if (this.milk < coffee.getMilkNeeded()) {
            message += "milk!";
        } else if(this.coffeeBeans < coffee.getCoffeeBeansNeeded()) {
            message += "coffee beans";
        }

        displayMessage(message);
    }

    private void processCoffee(Coffee coffee) {
        this.water -= coffee.getWaterNeeded();
        this.coffeeBeans -= coffee.getCoffeeBeansNeeded();
        this.milk -= coffee.getMilkNeeded();
        this.disposableCups -= 1;
        this.addMoney(coffee.getPrice());
    }

    private boolean checkSupply(Coffee coffee) {
        return this.disposableCups > 0
                && this.milk >= coffee.getMilkNeeded()
                && this.coffeeBeans >= coffee.getCoffeeBeansNeeded()
                && this.water >= coffee.getWaterNeeded();
    }

    private void displayMessage(String message){
        System.out.println(message);
    }

    private void addMoney(int amount){
        this.money += amount;
    }

    private void setMoney(int amount){
        this.money = amount;
    }

    public List<Coffee> getProducts() {
        return products;
    }

    public void setProducts(List<Coffee> products) {
        this.products = products;
    }

    public Coffee getCoffeeByType(int selected){

        CoffeeType type = null;
        if(selected == 1){
            type = CoffeeType.ESPRESSO;
        } else if (selected == 2){
            type = CoffeeType.LATTE;
        } else {
            type = CoffeeType.CAPPUCCINO;
        }

        List<Coffee> products1 = this.getProducts();

        for(Coffee coffee: products1){
            if(coffee.getType() == type){
                return coffee;
            }
        }

        return null;
    }
}
