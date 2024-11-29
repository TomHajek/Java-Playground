package dev.playground.designPatterns.structural.flyweight;

import java.awt.*;

/**
 * Shape implementation class to draw a line
 */
public class Line implements Shape {

    // Constructor
    public Line() {
        System.out.println("Creating Line object");

        // Adding time delay to mimic that the object creation for line is taking some time to create
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Implementing draw method to draw a line
    @Override
    public void draw(Graphics line, int x1, int y1, int x2, int y2, Color color) {
        line.setColor(color);
        line.drawLine(x1, y1, x2, y2);
    }

}