package DesignPattern.建造者模式;

public abstract class ColdDrink implements Item{

    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}
