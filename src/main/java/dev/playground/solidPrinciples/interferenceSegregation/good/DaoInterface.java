package dev.playground.solidPrinciples.interferenceSegregation.good;

/**
 * This is a good approach, we only include the dao operation and segregate connection part
 * so consumer can implement required interfaces.
 */
public interface DaoInterface {

    public void createRecord();
    public void deleteRecord();

}
