package view;

import presenter.Presenter;

import java.io.Console;

public class ConsoleUI implements View{
    private Presenter presenter;
    public ConsoleUI(){
        this.presenter = new Presenter(this);
    }

    @Override
    public void start() {
        System.out.println("///////////////////////////");
        System.out.println("Welcome!");
    }

    @Override
    public void print(String str) {
        System.out.println("//////////////////////\n" + str + "\n//////////////////////");
    }
}
