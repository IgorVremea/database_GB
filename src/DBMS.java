import model.Parser;
import model.Service;
import model.files.DatabaseManager;
import model.files.MyFile;
import view.ConsoleUI;

public class DBMS {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();

        DatabaseManager databaseManager = new DatabaseManager("./src/database");
        System.out.println(databaseManager.getFilesList() + "\n");
        Parser temp = new Parser();
        try {
            temp.parse("Vremea Igor Marcel 11.11.2001 078316153 m");
            System.out.println(temp);
        } catch (Exception e){
            System.out.println(e.getMessage() + "\n" + e.getClass());
        }
    }
}
