package model.files;

import java.io.*;

public class MyFile {
    private String address;
    private String fileName;
    public MyFile(String addr){
        this.address = addr;
        parseFileName();
        createFile();
    }
    public void createFile(){
        try{
            if(!(new File(address).exists())){
                System.out.println("File was created");
                new FileWriter(address);
            }
        } catch(IOException e) {
            System.out.println("File access error");
        }
    }
    public String getAddress() {
        return address;
    }
    public String getFileName(){
        return fileName;
    }
    public String getShortFileName(){
        return fileName.substring(0, fileName.indexOf("."));
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void write(String str) throws RuntimeException{
        try(FileWriter fw = new FileWriter(address)){
            fw.write(str);
        } catch (IOException e){
            throw new RuntimeException("File access error");
        }
    }
    public void append(String str) throws RuntimeException{
        try(FileWriter fw = new FileWriter(address, true)){
            fw.append(str);
        } catch (IOException e){
            throw new RuntimeException("File access error");
        }
    }
    public boolean isStringIn(String str) throws RuntimeException{
        try(BufferedReader file = new BufferedReader(new FileReader(address))) {
            String line;
            while ((line = file.readLine()) != null) {
                if (line.equals(str)) return true;
            }
        } catch(IOException e){
            throw new RuntimeException("File access error");
        }
        return false;
    }
    private void parseFileName(){
        int slashPos = address.lastIndexOf("\\");
        if(slashPos != -1){
            fileName = address.substring(slashPos + 1);
        } else {
            fileName = address;
        }
    }
}
