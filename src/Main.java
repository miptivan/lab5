import Controller.CollectionManager;
import Controller.CommandManager;

import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandManager commandmanager  = new CommandManager(new CollectionManager());
        commandmanager.run();
    }
}
