package dev.playground.designPatterns.creational.builder;

/**
 * The Most Common Way to implement the builder pattern is to have Builder class as inner class because:
 * - You might have seen at most of the places.
 * - Joshua Bloch's Builder pattern
 *
 * 1. We don't want to expose our constructor, which eventually creates confusion at a later stage.
 * 2. We don't want to have an inconsistent object by having setters exposed.
 * 3. Now, since the constructor is private, we will need inner class to access that.
 * - Which will have the same inputs what we have in class. But without getters.
 */
public class Burger {

    // Burger properties that user can assign to their burger
    private String size;
    private boolean egg;
    private boolean extraCheese;
    private boolean mayonese;
    private boolean onion;
    private boolean lettuce;

    // Private Constructor using burger builder as input parameter
    private Burger(BurgerBuilder burgerBuilder) {
        // Initialize all fields and you can also add validations.
    }

    // Getters for all the burger properties
    public String getSize() {
        return size;
    }

    public boolean isEgg() {
        return egg;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public boolean isMayonese() {
        return mayonese;
    }

    public boolean isOnion() {
        return onion;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    /*
     * Burger Builder:
     * Return the same object everytime that is builder instance.
     * Once build method invoke return the actual object.
     */
    public static class BurgerBuilder {

        // The same properties as in Burger class
        private String size;
        private boolean egg;
        private boolean extraCheese;
        private boolean mayonese;
        private boolean onion;
        private boolean lettuce;

        // Methods to set values for each property and return the value
        public BurgerBuilder size(String size) {
            this.size = size;
            return this;
        }
        public BurgerBuilder egg(boolean egg) {
            this.egg = egg;
            return this;
        }
        public BurgerBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }
        public BurgerBuilder mayonese(boolean mayonese) {
            this.mayonese = mayonese;
            return this;
        }
        public BurgerBuilder onion(boolean onion) {
            this.onion = onion;
            return this;
        }
        public BurgerBuilder lettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        // Once the properties are set, we have a build method that will help to create an entire object for us
        public Burger build() {
            return new Burger(this);
        }

    }

}
