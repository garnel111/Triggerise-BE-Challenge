import presentation.Menu;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {


        Menu mainMenu = new Menu();
        mainMenu.mainLoop();
    }
}
