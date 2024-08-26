package view;

import presenter.Presenter;

import java.util.Scanner;

public class Menu {
    private boolean isInProcess;
    private ConsoleUI consoleUI;
    Scanner scanner;
    public Menu(ConsoleUI consoleUI){
        isInProcess = true;
        scanner = new Scanner(System.in);
        this.consoleUI = consoleUI;
    }
    public void start(){
        String line;
        while(isInProcess){
            showMenuList();
            line = scanner.nextLine();
            switch(line){
                case "1":
                    consoleUI.showDatabase();
                    break;
                case "2":
                    System.out.println("Enter new data in format:\n<Surname> <Name> <Father's name> <dd.mm.yyyy> <012345678> <m/f>:");
                    consoleUI.addRecord(scanner.nextLine());
                    break;
            }
        }
    }
    public void showMenuList(){
        System.out.println("\n\nChoose an option:\n");
        System.out.println("1. Show all records from database");
        System.out.println("2. Add a record");
    }
}
