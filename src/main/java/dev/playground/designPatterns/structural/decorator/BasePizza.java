package dev.playground.designPatterns.structural.decorator;

public class BasePizza implements Pizza {

    @Override
    public String bake() {
        return "Base Pizza";
    }

}
