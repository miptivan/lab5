import Controller.CollectionManager;
import Controller.CommandManager;

import java.io.IOException;
import java.util.logging.*;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        CommandManager commandmanager  = new CommandManager(new CollectionManager());
        commandmanager.run();
    }
}
