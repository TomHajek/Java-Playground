package dev.playground.designPatterns.creational.builder;

/**
 * If we go via GOF Definition, The intent of the Builder design pattern is to separate the construction of a complex
 * object from its representation. By doing so, the same construction process can create different representations:
 *
 *  It means, for this Meal class, lets say we have a different representation (VegMeal and NonVegMeal).
 *  Also, this helps when you want to create object step by step as well.
 *
 *  So to achieve GOF, we have following components as a part of builder pattern:
 *
 *  1. Product - Which we are building
 *  2. AbstractBuilder - Which is helpful to provide the product
 *  3. Concrete builder - It is an actual builder, which helps us to provide specific representation of the object.
 *  4. Director - Uses this concrete builder (input), and based on that input, it goes and calls a particular builder
 *  (particular meal)
 */
public class Meal {

    // Properties of the meal object
    private String curry;
    private String bread;
    private String coldDrink;
    private String briyani;

    // Getters and Setters
    public String getCurry() {
        return curry;
    }

    public void setCurry(String curry) {
        this.curry = curry;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getColdDrink() {
        return coldDrink;
    }

    public void setColdDrink(String coldDrink) {
        this.coldDrink = coldDrink;
    }

    public String getBriyani() {
        return briyani;
    }

    public void setBriyani(String briyani) {
        this.briyani = briyani;
    }

}
