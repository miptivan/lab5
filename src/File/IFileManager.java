package File;
import Data.Person;

import java.io.IOException;
import java.util.ArrayDeque;

/**
 * The interface File manager.
 */
public interface IFileManager {
    /**
     * Save collection.
     *
     * @param collection the collection
     * @throws IOException the io exception
     */
    void saveCollection(ArrayDeque<Person> collection) throws IOException;
}
