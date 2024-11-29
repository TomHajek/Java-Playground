package dev.playground.designPatterns.creational.abstractFactory.os.win;

import dev.playground.designPatterns.creational.abstractFactory.CheckBox;

/**
 * Checkbox component for Windows app (implementing checkbox interface)
 */
public class WinCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("Win Checkbox");
    }

}
