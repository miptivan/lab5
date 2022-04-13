package Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class CommandManager implements ICommandManager{

    private final CollectionManager manager;
    public LinkedList<String> historyCollection = new LinkedList<>();
    public CommandManager(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() throws IOException {
        String input = "";
        String command;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello");
        while(!input.equals("exit")) {
            System.out.print("Enter command: ");
            input = reader.readLine();
            List<String> words = new ArrayList<String>(Arrays.asList(input.split(" ")));
            // words.removeAll(Arrays.asList("", null));
            commandManager(words);
        }
    }

    /**
     *
     * @param s - команда пользователя и аргумент
     *
     */
    @Override
    public void commandManager(List<String> s) {
        try {
            switch (s.get(0)) {
                case "help":
                    manager.help();
                    historyCollection.addFirst("help");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                case "info":
                    manager.info();
                    historyCollection.addFirst("info");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                case "show":
                    manager.show();
                    historyCollection.addFirst("show");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                case "exit":
                    break;
                case "add":
                case "add_last": {
                    manager.addLast();
                    historyCollection.addFirst("add");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "add_first":{
                    manager.addFirst();
                    historyCollection.addFirst("add_first");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "clear":{
                    manager.clear();
                    historyCollection.addFirst("clear");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "remove_first":{
                    manager.removeFirst();
                    historyCollection.addFirst("remove_first");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "remove_last":{
                    manager.removeLast();
                    historyCollection.addFirst("remove_last");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "add_if_max":{
                    manager.addIfMax();
                    historyCollection.addFirst("add_if_max");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "history":{
                    for (String item: historyCollection){
                        System.out.println(item);
                    }

                    historyCollection.addFirst("history");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "filter_greater_than_height":{
                    manager.filter_greater_than_height();
                    historyCollection.addFirst("filter_greater_than_height");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "print_ascending":{
                    manager.print_ascending();
                    historyCollection.addFirst("print_ascending");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "save":{
                    manager.save();
                    historyCollection.addFirst("save");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                case "execute_script":{
                    manager.execute_script(s.get(1));
                    historyCollection.addFirst("execute_script");
                    if (historyCollection.size() == 9){
                        historyCollection.removeLast();
                    }
                    break;
                }
                default:
                    System.out.println("Command not found. Enter \"help\" to get a list of commands.");
            }
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            // JsonProcessing.log.warning("ArrayIndexOutOfBoundsException");
            System.out.println("Need a numeric argument!");

        }

    }
}
