package dev.playground.designPatterns.structural.flyweight;

import java.util.HashMap;

/**
 * FlyWeight factory - will identify the different objects based on intrinsic values, and it will
 * return the object
 */
public class ShapeFactory {

    // Map to store locally the created shapes
    private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();

    // The object will be created based on ShapeType parameter
    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            // The object with intrinsic values will be put in a maps (to be created only once and reused)
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public static enum ShapeType {
        OVAL_FILL,
        OVAL_NOFILL,
        LINE;
    }

}