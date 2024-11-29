package dev.playground.designPatterns.creational.factory;

/**
 * Factory:
 * As name suggests it is a factory where we can create objects.
 * Since it creates an object, it falls in a creational design pattern.
 * The Factory pattern has two important elements in its design.
 *
 * 1. Interface/Abstract class:
 * This is the base element for which we are making factory, i.e. we are going to get the object of this type.
 * In this case, it is "OperatingSystem" which has type available Windows and Linux.
 *
 * 2. Factory:
 * This will have nothing but Object creation logic.
 * Let's say as a library you introduce one more subtype that is MacOperatingSystem.
 * Now your caller is automatically extended to this facility of third type. Also, we have taken responsibility for
 * creating of the object.
 *
 * In java, this pattern is heavily used:
 *
 * 1. Calendar.getInstance:
 * Calendar is abstract class and based on Local and Timezone we provided it is giving calendar instance.
 * Note in this case, we really don't know what type of calendar we got.
 *
 * 2. In reflection Class.forName: the type of class you pass it gets loaded.
 *
 * Best link to learn java and patterns used:
 * https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries
 *
 */
public class OperatingSystemFactory {

    // Private constructor: factory should not be created directly, but through the getInstance method call
    private OperatingSystemFactory() {

    }

    /*
     * One more advantage, tomorrow you plan to change OS here, you can simply change this, and everything works as it is.
     * Example creation of an object:

        OperatingSystem operatingSystem = OperatingSystemFactory.getInstance("WINDOWS" , "WIN7" ,"x64");
        OperatingSystem operatingSystem2 = OperatingSystemFactory.getInstance("LINUX" , "DEB" ,"x64");

     */

    // Static method: creates an OS object based on parameters
    public static OperatingSystem getInstance(String type, String version, String architecture) {
        switch (type) {
            case "WINDOWS":
                return new WindowsOperatingSysten(version,architecture);
            case "LINUX":
                return new LinuxOperatingSystem(version,architecture);
            default:
                throw new IllegalArgumentException("OS Not supported");
        }
    }

}
