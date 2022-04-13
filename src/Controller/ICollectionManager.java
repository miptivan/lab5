package Controller;

import java.io.IOException;

/**
 * The interface Collection manager.
 */
public interface ICollectionManager {
    /**
     * Help.
     */
    void help();

    /**
     * Info.
     */
    void info();

    /**
     * Add first.
     *
     * @throws IOException the io exception
     */
    void addFirst() throws IOException;

    /**
     * Add last.
     *
     * @throws IOException the io exception
     */
    void addLast() throws IOException;

    /**
     * Clear.
     */
    void clear();

    /**
     * Remove first.
     */
    void removeFirst();

    /**
     * Remove last.
     */
    void removeLast();

    /**
     * Add if max.
     *
     * @throws IOException the io exception
     */
    void addIfMax() throws IOException;

    /**
     * Filter greater than height.
     */
    void filter_greater_than_height();

    /**
     * Print ascending.
     */
    void print_ascending();

    /**
     * Show.
     */
    void show();

    /**
     * Save.
     *
     * @throws IOException the io exception
     */
    void save() throws IOException;

    /**
     * Execute script.
     *
     * @param file_name the file name
     */
    void execute_script(String file_name);
}
