package dev.playground.designPatterns.creational.abstractFactory;

import dev.playground.designPatterns.creational.abstractFactory.uifactory.UIFactory;

public class Application {

    // All apps contain button and checkbox
    private Button button;
    private CheckBox checkbox;

    // Constructor is taking UI Factory
    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

}
