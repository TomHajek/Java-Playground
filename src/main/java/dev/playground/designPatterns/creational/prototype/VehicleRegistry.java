package dev.playground.designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * This vehicle registry is nothing but a hash map of string and vehicle
 */
public class VehicleRegistry {

    private static Map<String,Vehicle> mapVehicles = new HashMap<>();

    /*
     * Withing the starting of the application itself, we are creating prototypes and storing them in registry.
     * So whenever the application starts, we have a prototypes ready.
     */
    static {
        mapVehicles.put("TWO", new TwoWheelerVehicle("120","royal",100000,false));
        mapVehicles.put("FOUR", new FourWheelerVehicle("120","bmw", false,100000,false));
    }

    /*
     * Whoever wants a particular object, they can get directly by the value that they pass.
     * For ex. user passes "TWO" and gets a two-wheeler object (clone).
     */
    public Vehicle getVehicle(String vehicle) throws CloneNotSupportedException {
        return mapVehicles.get(vehicle).clone();
    }

}
