package DesignPattern.建造者模式;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        return (float) items.stream().mapToDouble(Item::price).sum();
    }

    public void showItems() {
        items.forEach(item -> {
            System.out.print("Item: " + item.name());
            System.out.print(", Packing : " + item.packing());
            System.out.print(", Price : " + item.price());
        });
    }

}
