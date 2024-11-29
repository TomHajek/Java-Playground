package dev.playground.designPatterns.creational.builder;

public class NonVegMealBuilder extends MealBuilder {
    private Meal meal;

    // Constructor which will return the Meal object
    public NonVegMealBuilder() {
        meal = new Meal();
    }

    // Implementation of all abstract methods from Meal Builder
    @Override
    public void addBriyani() {
        this.meal.setBriyani("Chicken");
    }

    @Override
    public void addBread() {
        this.meal.setBread("Roti");
    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Sprite");
    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Non-Veg");
    }

    @Override
    public Meal build() {
        return meal;
    }

}
