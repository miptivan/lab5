package Exceptions;

public class IncorrectValueException extends Throwable {
    /**
     * Instantiates a new Incorrect value exception.
     */
    public IncorrectValueException(){
        super("Value is incorrect");
    }
}
