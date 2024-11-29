package dev.playground.solidPrinciples.interferenceSegregation.good;

/**
 * Here don't need to bother about db part.
 */
public class FileDaoConnection implements FileInterface, DaoInterface {

    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openFile() {

    }

}
