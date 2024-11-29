package dev.playground.designPatterns.creational.builder;

public class VegMealBuilder extends MealBuilder {

    private Meal meal;

    // Constructor which will return the Meal object
    public VegMealBuilder() {
        meal = new Meal();
    }

    // Implementation of all abstract methods from Meal Builder
    @Override
    public void addBriyani() {
        this.meal.setBriyani("Veg");
    }

    @Override
    public void addBread() {
        this.meal.setBread("Naan");
    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Sprite");
    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Veg");
    }

    @Override
    public Meal build() {
        return meal;
    }

}
