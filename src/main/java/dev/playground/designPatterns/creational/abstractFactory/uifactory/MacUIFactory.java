package dev.playground.designPatterns.creational.abstractFactory.uifactory;

import dev.playground.designPatterns.creational.abstractFactory.Button;
import dev.playground.designPatterns.creational.abstractFactory.CheckBox;
import dev.playground.designPatterns.creational.abstractFactory.os.mac.MacButton;
import dev.playground.designPatterns.creational.abstractFactory.os.mac.MacCheckBox;

/**
 * Extends ui factory (interface) and creates buttons and checkboxes for Mac app.
 * When we are implementing this factory, we get MacButton and MacCheckbox by default.
 */
public class MacUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }

}
