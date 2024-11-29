package dev.playground.designPatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Here we have a Swiggy store focused in food delivery
 */
public class SwiggyStore {

    // List of items for sale/delivery
   List<Item> items = new ArrayList<>();

   // Method to add items to the store
   public void addItems(Item item) {
       items.add(item);
   }

}
