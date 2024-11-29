package dev.playground.solidPrinciples.interferenceSegregation.bad;

public class BadFileDaoConnection implements BadDaoInteface {

    @Override
    public void openConnection() {
        //We can't open connection in file system
    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public void deleteRecord() {

    }

}
