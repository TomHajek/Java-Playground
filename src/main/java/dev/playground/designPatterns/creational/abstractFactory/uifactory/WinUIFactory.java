package dev.playground.designPatterns.creational.abstractFactory.uifactory;

import dev.playground.designPatterns.creational.abstractFactory.Button;
import dev.playground.designPatterns.creational.abstractFactory.CheckBox;
import dev.playground.designPatterns.creational.abstractFactory.os.win.WinButton;
import dev.playground.designPatterns.creational.abstractFactory.os.win.WinCheckBox;

/**
 * Extends ui factory (interface) and creates buttons and checkboxes for Win app.
 * When we are implementing this factory, we get WinButton and WinCheckbox by default.
 */
public class WinUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }

}
