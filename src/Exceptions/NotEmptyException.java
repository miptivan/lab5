package Exceptions;

/**
 * The type Not empty exception.
 */
public class NotEmptyException extends Exception{
    /**
     * Instantiates a new Not empty exception.
     */
    public NotEmptyException(){
        super("Element can not be empty");
    }
}
