package model;

import javax.print.attribute.standard.NumberUp;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private boolean sex;
    private static String dateFormatterPattern = "dd.MM.uuuu";
    private static String phoneNumberExample = "012345678";
    public Parser(){
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public static String getDateFormatterPattern() {
        return dateFormatterPattern;
    }

    public static String getPhoneNumberExample() {
        return phoneNumberExample;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void setDateFormatterPattern(String dateFormatterPattern) {
        Parser.dateFormatterPattern = dateFormatterPattern;
    }

    public static void setPhoneNumberExample(String phoneNumberExample) {
        Parser.phoneNumberExample = phoneNumberExample;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public String getDateOfBirthStr() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern(dateFormatterPattern));
    }
    public void setDateOfBirth(LocalDate date){
        dateOfBirth = date;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public String getPhoneNumberStr(){
        return "0" + phoneNumber;
    }

    public char getSex() {
        if(sex){
            return 'm';
        } else {
            return 'f';
        }
    }
    public String getSexStr(){
        return sex == true ? "male" : "female";
    }
    public void setSex(char c) throws IOException{
        sex = parseSex(Character.toString(c));
    }

    public void parse(String str) throws IOException {
        String[] arr = str.split("\s");
        if(arr.length != 6) throw new IOException("Wrong quantity of parameters");
        surname = parseWord(arr[0],"surname");
        name = parseWord(arr[1],"name");
        fatherName = parseWord(arr[2],"father's name");
        dateOfBirth = parseDate(arr[3]);
        phoneNumber = parsePhoneNumber(arr[4]);
        sex = parseSex(arr[5]);

    }
    public String parseWord(String str, String wordType)throws IOException{
        if(isValidStringOfLetters(str)){
            return str;
        } else {
            throw new IOException("Wrong " + wordType + " format");
        }
    }
    public LocalDate parseDate(String str) throws IOException{
        if(isValidDate(str)){
            return LocalDate.parse(str, DateTimeFormatter.ofPattern(dateFormatterPattern));
        } else {
            throw new IOException("Wrong date format");
        }
    }
    public long parsePhoneNumber(String str) throws IOException{
        if(!isValidPhoneNumber(str)){
            throw new IOException("Wrong phone number format");
        }
        return Long.parseLong(str);
    }
    public boolean parseSex(String str) throws IOException{
        if(str.length() > 1) throw new IOException("Wrong sex input format");
        if(str.charAt(0) == 'm'){
            return true;
        } else if (str.charAt(0) == 'f'){
            return false;
        } else {
            throw new IOException("Wrong sex character");
        }
    }
    public static boolean isValidStringOfLetters(String str){
        for(char c : str.toCharArray()) {
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatterPattern);
        try{
            LocalDate temp = LocalDate.parse(str, formatter);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // Проверка только на соответствие молдавского формата номера
    public static boolean isValidPhoneNumber(String str){
        if(str.length() != phoneNumberExample.length()) return false;
        for(char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        if(str.charAt(0) != '0') return false;
        return true;
    }

    @Override
    public String toString() {
        return surname + ' ' +
                name + ' ' +
                fatherName + ' ' +
                getDateOfBirthStr() + ' ' +
                 '0' + phoneNumber + ' ' +
                getSex();
    }
}
