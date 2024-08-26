package model;

import model.files.DatabaseManager;
import model.files.MyFile;

import java.io.IOException;

public class Service {
    DatabaseManager databaseManager;

    public Service(){
        databaseManager = new DatabaseManager("./src/database");
    }

    public void showDatabase(){
        databaseManager.showAllRecords();
    }
    public void addRecord(String record){
        Parser parser = new Parser();
        try{
            parser.parse(record);
            databaseManager.addRecordInFileByShortName(parser.getSurname(), parser.toString());
        } catch (IOException e){
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
    }
}
