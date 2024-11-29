package dev.playground.designPatterns.creational.factory;

/**
 * Abstract class, the base class for which we are making factory, i.e. we are going to get the object of this type.
 * In this case, it is "OperatingSystem" which has a type available (Windows / Linux).
 */
public abstract class OperatingSystem {

    private String  version;
    private String architecture;

    // GETTERS & SETTERS
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    // CONSTRUCTOR
    public OperatingSystem(String version, String architecture) {
        this.version = version;
        this.architecture = architecture;
    }

    // ABSTRACT METHODS (these methods going to be different based on OS)
    public abstract void changeDir(String dir);
    public abstract void removeDir(String dir);

}
