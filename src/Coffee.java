public class Coffee {

    private CoffeeType type;
    private int price;
    private int waterNeeded;
    private int milkNeeded;
    private int coffeeBeansNeeded;

    public Coffee(CoffeeType type, int price, int waterNeeded, int milkNeeded, int coffeeBeansNeeded){
        this.type = type;
        this.price = price;
        this.waterNeeded = waterNeeded;
        this.milkNeeded = milkNeeded;
        this.coffeeBeansNeeded = coffeeBeansNeeded;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType coffeeType) {
        this.type = coffeeType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public void setMilkNeeded(int milkNeeded) {
        this.milkNeeded = milkNeeded;
    }

    public int getCoffeeBeansNeeded() {
        return coffeeBeansNeeded;
    }

    public void setCoffeeBeansNeeded(int coffeeBeansNeeded) {
        this.coffeeBeansNeeded = coffeeBeansNeeded;
    }
}
