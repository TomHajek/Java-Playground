package dev.playground.solidPrinciples.interferenceSegregation.bad;

public class BadDbDaoConnection implements BadDaoInteface {

    @Override
    public void openConnection() {
        //Connection logic
    }

    @Override
    public void createRecord() {
        //Create record logic
    }

    @Override
    public void openFile() {
        // We are in DB Connection so no need to support open file
        throw new UnsupportedOperationException("Open file Not supported");
    }

    @Override
    public void deleteRecord() {
        // This is fine
    }

}
