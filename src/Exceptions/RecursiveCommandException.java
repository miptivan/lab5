package Exceptions;

public class RecursiveCommandException extends Throwable {
    public RecursiveCommandException(){
        super("Команда вызывается рекурсивно - выполнение скрипта будет бесконечным");
    }
}
