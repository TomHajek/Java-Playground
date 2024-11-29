package dev.playground.designPatterns.creational.abstractFactory.os.mac;

import dev.playground.designPatterns.creational.abstractFactory.Button;

/**
 * Button component for Mac app (implementing button interface)
 */
public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Mac Button");
    }

}
