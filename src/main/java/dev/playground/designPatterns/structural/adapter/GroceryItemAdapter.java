package dev.playground.designPatterns.structural.adapter;

/**
 * This is the example of object level adapter, because we are adapting groceryItem using
 * instance of that particular class.
 *
 * Here we have a grocery item adapter that implements the item interface.
 * So here we are implementing all the methods from Item.
 */
public class GroceryItemAdapter implements Item {

    private GroceryItem item;

    // Now, whenever we are creating the object, we take grocery item here
    public GroceryItemAdapter(GroceryItem item) {
        this.item = item;
    }

    // So here, where we are implementing Item methods, we are basically mapping GroceryItem to Item
    @Override
    public String getItemName() {
        return item.getName();
    }

    @Override
    public String getPrice() {
        return item.getPrice();
    }

    @Override
    public String getRestaurantName() {
        return item.getStoreName();         // adapting storeName to restaurantName
    }

}
