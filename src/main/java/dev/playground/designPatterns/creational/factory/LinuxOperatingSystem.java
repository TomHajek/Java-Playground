package dev.playground.designPatterns.creational.factory;

/**
 * Class for specific OS (linux), extending abstract class "OS"
 */
public class LinuxOperatingSystem extends OperatingSystem {

    public LinuxOperatingSystem(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {

    }

    @Override
    public void removeDir(String dir) {

    }

}
