package dev.playground.designPatterns.creational.prototype;

/**
 * This two-wheeler vehicle is extending the base Vehicle class and has some extra property.
 */
public class TwoWheelerVehicle extends Vehicle {

    private boolean isElectric;

    public TwoWheelerVehicle(String engine, String model, long price, boolean isElectric) {
        super(engine, model, price);  // Properties from "base" vehicle
        this.isElectric = isElectric; // TwoWheelerVehicle property
    }

    // This vehicle should have a clone method as well

}
