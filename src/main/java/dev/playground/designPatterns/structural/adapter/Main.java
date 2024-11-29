package dev.playground.designPatterns.structural.adapter;

/**
 * Adapter patterns comes under a structural pattern as it deals with how classes are interacting.
 * As the name suggests, an adapter pattern is used to adapt to different types. So this pattern should be used whenever
 * we want to adapt to different implementations or different interfaces provided at the time.
 *
 * Adapter pattern also helps and is a connector between your system and some third party or legacy system.
 * For example, your system expects data in one format to process and third party sends in one format.
 *
 * To simplify, it is like, when you are traveling and need to charge your phone, you need an adapter for a different
 * socket.
 *
 * Example:
 * Consider you have to invoke some third-party soap service, which is xml based. However, your system is built on JSON
 * with some advanced fields at that time you create JSON-to-XML adapter, which will help you to interact with a third
 * party.
 *
 * Adapter pattern can be achieved in two ways:
 *
 * 1. Class Level: class level means to adapt something you are extending and doing inheritance of that class.
 * 2. Object level: Object level means you keep has-a relationship with class, rather doing tight coupling in the system.
 *
 * One of the examples is we know java supports both array and list to store data. Now you have a legacy system, which
 * is using an array, and you want to use collection functionalities to do so we have to convert, so Arrays.asList work
 * as adapter between the array and list and then use collections.
 *
 * A java.io.InputStreamReader translates a byte stream into a character stream, and a java.io.OutputStreamWriter
 * translates a character stream into a byte stream. These classes exemplify the Adapter pattern. In particular, they
 * change input/output stream interfaces to the required reader/writer interfaces:
 *
 * https://cecs.wright.edu/~tkprasad/courses/ceg860/paper/node26.html
 *
 * In this example, we will see that Swiggy (food delivery) is selling food products. Now suddenly lockdown arises,
 * and they thought to provide service of delivering grocery items as well, so they write an adapter which helps them to
 * convert similar food items without touching their food delivery business:
 *
 * https://www.javadevjournal.com/java-design-patterns/adapter-design-pattern/
 *
 * Reference: https://www.programmergirl.com/java-adapter-pattern/
 */
public class Main {

    public static void main(String[] args) {
        SwiggyStore swiggyStore = new SwiggyStore();
        swiggyStore.addItems(new FoodItem());
        swiggyStore.addItems(new FoodItem());

        /*
         * Here GroceryItem was incompatible with FoodItem (Item),
         * so we had to use GroceryItemAdapter to adapt (convert) Grocery to Food
         */
        swiggyStore.addItems(new GroceryItemAdapter(new GroceryProduct()));
    }

}
