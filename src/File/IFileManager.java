package File;
import Data.Person;

import java.io.IOException;
import java.util.ArrayDeque;

public interface IFileManager {
    void saveCollection(ArrayDeque<Person> collection) throws IOException;
}
