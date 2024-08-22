import model.Service;
import model.files.DatabaseManager;
import model.files.MyFile;
import view.ConsoleUI;

public class DBMS {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();

        DatabaseManager databaseManager = new DatabaseManager("./src/database");
        System.out.println(databaseManager.getFilesList());
    }
}
