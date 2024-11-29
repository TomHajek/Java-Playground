package dev.playground.designPatterns.creational.prototype;

/**
 * This is a "base" prototype class.
 * This class can be cloned (copied) and modified as a new object (for ex. TwoWheelerVehicle).
 */
public abstract class Vehicle implements Cloneable {

    // Properties of this abstract class
    private String engine;
    private String model;
    private long price;

    // Constructor
    public Vehicle(String engine, String model,  long price) {
        this.engine = engine;
        this.model = model;
        this.price = price;
    }

    // Getters & Setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    /*
     * This method is returning a Vehicle object by doing the clone operation.
     * It will clone the object, convert it to vehicle, and return it.
     */
    protected Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }

}
