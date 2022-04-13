package Controller;

import java.io.IOException;

public interface ICollectionManager {
    void help();
    void info();
    void addFirst() throws IOException;
    void addLast() throws IOException;
    void clear();
    void removeFirst();
    void removeLast();
    void addIfMax() throws IOException;
    void filter_greater_than_height();
    void print_ascending();
    void show();
    void save() throws IOException;
    void execute_script(String file_name);
}
