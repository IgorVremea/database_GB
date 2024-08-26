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
            if(!isStringIn(str)){
                fw.append(str + '\n');
            }
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFileName());
        stringBuilder.append('\n');
        try(BufferedReader file = new BufferedReader(new FileReader(address))) {
            String line;
            while ((line = file.readLine()) != null) {
                stringBuilder.append("\t");
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch(IOException e){
            throw new RuntimeException("File access error");
        }
        return stringBuilder.toString();
    }

    private void parseFileName(){
        if(address.lastIndexOf("\\") != -1){
            fileName = address.substring(address.lastIndexOf("\\") + 1);
        } else if (address.lastIndexOf("/") != -1){
            fileName = address.substring(address.lastIndexOf("/") + 1);
        } else {
            fileName = address;
        }
    }
}
