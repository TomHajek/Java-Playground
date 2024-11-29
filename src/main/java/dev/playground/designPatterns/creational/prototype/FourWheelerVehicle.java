package dev.playground.designPatterns.creational.prototype;

/**
 * This four-wheeler vehicle is again extending the base Vehicle class and has some extra properties.
 */
public class FourWheelerVehicle extends Vehicle {

    private boolean automatic;
    private boolean isDiesel;

    public FourWheelerVehicle(String engine, String model, boolean automatic, long price, boolean isDiesel) {
        super(engine, model, price);  // Properties from "base" vehicle
        this.automatic = automatic;   // FourWheelerVehicle properties
        this.isDiesel = isDiesel;
    }

    // Additionally, this vehicle also has a clone method
    protected FourWheelerVehicle clone() throws CloneNotSupportedException {
        return (FourWheelerVehicle) super.clone();
    }

}
