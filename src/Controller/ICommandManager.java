package Controller;

import java.io.IOException;
import java.util.List;

public interface ICommandManager {
    void run() throws IOException;
    void commandManager(List<String> s);
}
