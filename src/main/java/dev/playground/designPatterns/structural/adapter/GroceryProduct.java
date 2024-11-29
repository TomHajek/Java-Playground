package dev.playground.designPatterns.structural.adapter;

/**
 * To make food item and grocery item compatible,
 * we need to implement the grocery item interface as well.
 */
public class GroceryProduct implements GroceryItem {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public String getStoreName() {
        return null;
    }

}
