package Controller;

import Data.Coordinates;

public interface IAskManager {
    String askName();
    Coordinates askCoordinates();
    Long askCoordinateX();
    Integer askCoordinateY();
    Integer askHeight();
}
