package model.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private String databasePath;
    private List<MyFile> filesList;
    public DatabaseManager(String databasePath){
        this.databasePath = databasePath;
        this.filesList = new ArrayList<>();
        filesListInit();
    }
    private void filesListInit(){
        File dir = new File(databasePath);
        for(File fileEntry : dir.listFiles()){
            if(!fileEntry.isDirectory()) {
                filesList.add(new MyFile(fileEntry.getPath()));
            }
        }
    }
    public String getFilesList(){
        StringBuilder filesNameList = new StringBuilder();
        for(MyFile file : filesList){
            filesNameList.append(file.getFileName());
            filesNameList.append("\n");
        }
        return filesNameList.toString();
    }
    public boolean isExistFileByShortName(String fileName){
        for (MyFile file : filesList){
            if(file.getShortFileName().equals(fileName)) return true;
        }
        return false;
    }
    public MyFile getFileByShortName(String fileName){
        for (MyFile file : filesList){
            if(file.getShortFileName().equals(fileName)) return file;
        }
        return null;
    }
    public void createFile(String fileName){
        MyFile newFile;
        if(fileName.indexOf(".") == -1) {
            newFile = new MyFile(databasePath + fileName + ".mydata");
        } else {
            newFile = new MyFile(databasePath + fileName);
        }
        filesList.add(newFile);
    }
    public void addRecordInFileByShortName(String fileName, String record){
        MyFile tempFile = getFileByShortName(fileName);
        if(tempFile != null){
            tempFile.append(record);
        } else {
            MyFile newFile = new MyFile(databasePath + "/" + fileName + ".mydata");
            filesList.add(newFile);
            newFile.append(record);
        }
    }
    public void showAllRecords(){
        for(MyFile file : filesList){
            System.out.println(file.toString());
        }
    }
}
