package Exceptions;

/**
 * The type Recursive command exception.
 */
public class RecursiveCommandException extends Throwable {
    /**
     * Instantiates a new Recursive command exception.
     */
    public RecursiveCommandException(){
        super("Команда вызывается рекурсивно - выполнение скрипта будет бесконечным");
    }
}
