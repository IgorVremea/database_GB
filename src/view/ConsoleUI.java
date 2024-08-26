package view;

import presenter.Presenter;

import java.io.Console;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Menu menu;
    public ConsoleUI(){
        this.presenter = new Presenter(this);
        menu = new Menu(this);
    }

    @Override
    public void start() {
        System.out.println("///////////////////////////");
        System.out.println("Welcome!");
        menu.start();
    }
    public void showDatabase(){
        presenter.showDatabase();
    }
    public void addRecord(String record){
        presenter.addRecord(record);
    }
    @Override
    public void print(String str) {
        System.out.println("//////////////////////\n" + str + "\n//////////////////////");
    }
}
