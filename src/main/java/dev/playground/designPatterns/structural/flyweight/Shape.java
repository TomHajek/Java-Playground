package dev.playground.designPatterns.structural.flyweight;

import java.awt.*;

/**
 * Shape interface to draw a shape based on the input. All the different shapes that we are going to create will go
 * through this draw method.
 */
public interface Shape {

    public void draw(Graphics g, int x, int y, int width, int height, Color color);

}
