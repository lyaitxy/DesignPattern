package DesignPattern.建造者模式;

public abstract class Burger implements Item{
    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}
