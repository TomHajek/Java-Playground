package dev.playground.designPatterns.structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * FlyWeight design pattern is also known as "Caching" design pattern.
 *
 * Usage:
 * 1. When does your application have a huge number of object creations.
 * 2. Objects that we are creating are huge/heavy in processing (memory consumption), which is taking too much time
 * on creating them.
 * 3. When object properties can be divided into intrinsic properties (the object is unique) and extrinsic properties
 * (properties added by the client).
 *
 * References: https://www.digitalocean.com/community/tutorials/flyweight-design-pattern-java
 *
 * Let's say, we want to create shapes (oval, line, rectangle, etc.), so we call constructors of each object and object
 * will be created. Assume that it takes 1sec to create each object, since it has both intrinsic and extrinsic
 * properties and hence it would take too much time.
 *
 * With flyweight design pattern, we are going to use the "Shape" interface. For this Shape, we will have different
 * concrete classes (line, oval, rectangle, etc.) with intrinsic and extrinsic properties. Each will also have its
 * own constructor, but we won't be using it directly. We are going to create a FlyWeight Factory instead, and from that
 * factory, the objects will be created. Based on the shape type, we will have a hashmap to store all the different
 * objects. We won't be creating a new object every time we check a map if the object is available and if not, then we
 * create a new object. By this, we are minimizing "heavy lifting" by creating the object. That is the idea of flyweight
 * design pattern and also why it is sometimes called "caching design pattern."
 *
 */
public class DrawingClient extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;
    private final int WIDTH;
    private final int HEIGHT;

    private static final ShapeFactory.ShapeType shapes[] = {
            ShapeFactory.ShapeType.LINE,
            ShapeFactory.ShapeType.OVAL_FILL,
            ShapeFactory.ShapeType.OVAL_NOFILL
    };

    private static final Color colors[] = {
            Color.RED,
            Color.GREEN,
            Color.YELLOW
    };

    public DrawingClient(int width, int height) {
        this.WIDTH=width;
        this.HEIGHT=height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Graphics g = panel.getGraphics();
                for (int i = 0; i < 20; ++i) {
                    Shape shape = ShapeFactory.getShape(getRandomShape());
                    shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
                            getRandomHeight(), getRandomColor());
                }
            }
        });
    }

    private ShapeFactory.ShapeType getRandomShape() {
        return shapes[(int) (Math.random() * shapes.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10));
    }

    private Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    public static void main(String[] args) {
        DrawingClient drawing = new DrawingClient(500,600);
    }

}
