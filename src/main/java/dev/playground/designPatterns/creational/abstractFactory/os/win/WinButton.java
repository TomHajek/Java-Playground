package dev.playground.designPatterns.creational.abstractFactory.os.win;

import dev.playground.designPatterns.creational.abstractFactory.Button;

/**
 * Button component for Windows app (implementing button interface)
 */
public class WinButton implements Button {

    @Override
    public void paint() {
        System.out.println("Win Button");
    }

}
