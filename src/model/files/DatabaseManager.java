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
}
