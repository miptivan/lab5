package Controller;

import java.io.IOException;
import java.util.List;

/**
 * The interface Command manager.
 */
public interface ICommandManager {
    /**
     * Run.
     *
     * @throws IOException the io exception
     */
    void run() throws IOException;

    /**
     * Command manager.
     *
     * @param s the s
     */
    void commandManager(List<String> s);
}
