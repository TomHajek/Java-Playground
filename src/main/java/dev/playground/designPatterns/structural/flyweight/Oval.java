package dev.playground.designPatterns.structural.flyweight;

import java.awt.*;

/**
 * Shape implementation class to draw an oval shape
 */
public class Oval implements Shape {

    // Intrinsic property
    private boolean fill;

    // Constructor
    public Oval(boolean f) {
        this.fill = f;
        System.out.println("Creating Oval object with fill="+f);

        // Adding time delay to mimic that the object creation for line is taking some time to create
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Implementing draw method to draw an oval shape
    @Override
    public void draw(Graphics circle, int x, int y, int width, int height, Color color) {
        circle.setColor(color);
        circle.drawOval(x, y, width, height);

        if(fill) {
            circle.fillOval(x, y, width, height);
        }
    }

}