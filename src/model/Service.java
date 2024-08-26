package model;

import model.files.MyFile;

public class Service {
    MyFile database;
    public Service(){
        database = new MyFile("./src/database/test.mydata");
    }
    public boolean findStringInFile(String str){
        return database.isStringIn(str);
    }

}
