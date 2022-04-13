package Controller;

import Data.Coordinates;

/**
 * The interface Ask manager.
 */
public interface IAskManager {
    /**
     * Ask name string.
     *
     * @return the string
     */
    String askName();

    /**
     * Ask coordinates coordinates.
     *
     * @return the coordinates
     */
    Coordinates askCoordinates();

    /**
     * Ask coordinate x long.
     *
     * @return the long
     */
    Long askCoordinateX();

    /**
     * Ask coordinate y integer.
     *
     * @return the integer
     */
    Integer askCoordinateY();

    /**
     * Ask height integer.
     *
     * @return the integer
     */
    Integer askHeight();
}
