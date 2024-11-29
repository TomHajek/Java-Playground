package dev.playground.solidPrinciples.interferenceSegregation.bad;

/**
 * This dao interface defined to support data access using file system
 * or database system. So we have added openConnection and openFile for it,
 * this is bad because we have to accommodate all operations in a single interface.
 */
public interface  BadDaoInteface {

    public void openConnection();
    public void createRecord();
    public void openFile();
    public void deleteRecord();

}
