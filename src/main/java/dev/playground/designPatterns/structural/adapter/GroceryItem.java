package dev.playground.designPatterns.structural.adapter;

/**
 * Now we want to add grocery item to our Swiggy store,
 * but this Item is different from food item.
 *
 * So we need to make sure that both are compatible.
 */
public interface GroceryItem {

    String getName();
    String getPrice();
    String getStoreName();

}
