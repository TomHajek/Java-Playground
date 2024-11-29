package dev.playground.solidPrinciples.interferenceSegregation.good;

/**
 * Implemented method what is actual being operated by this.
 * We don't have to bother about file operation as interface segregated.
 */
public class DbDaoConnection implements DaoInterface, DbInterface {

    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openConnection() {

    }

}
