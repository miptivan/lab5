package Controller;
import Data.Person;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import Exceptions.RecursiveCommandException;
import File.FileManager;

public class CollectionManager implements ICollectionManager {
    HashMap<String, String> helpCommands;

    private final java.util.Date creation = new Date();
    public Deque<Person> personCollection = new ArrayDeque<>();
    private final AskManager askManager = new AskManager();


    private static final AtomicInteger currID = new AtomicInteger();
    private int getId(){
        return currID.getAndIncrement();
    }

    public CollectionManager() throws IOException {
        helpCommands = new HashMap<>();
        helpCommands.put("help:", "Вывести справку по доступным командам");
        helpCommands.put("info:", "Вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)");
        helpCommands.put("show:", "Вывести в стандартный поток вывода все элементы коллекции в строковом " +
                "представлении");
        helpCommands.put("add {element}:", "Добавить новый элемент в коллекцию");
        helpCommands.put("update {id}:", "обновить значение элемента коллекции, id которого равен заданному");
        helpCommands.put("remove_by_id {id}:", "удалить элемент из коллекции по его id");
        helpCommands.put("clear:", "Очистить коллекцию");
        helpCommands.put("save:", "Сохранить коллекцию в файл");
        helpCommands.put("execute_script file_name :", "Считать и исполнить скрипт из указанного файла. В скрипте " +
                "содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        helpCommands.put("remove_first:", "Удалить первый элемент из коллекции");
        helpCommands.put("add_if_max {element}:", "Добавить новый элемент в коллекцию, если его значение превышает " +
                "значение наибольшего элемента этой коллекции");
        helpCommands.put("history:", "Вывести последние 9 команд (без их аргументов)");
        helpCommands.put("filter_greater_than_height {height} :", "вывести элементы, значение поля height которых " +
                "больше заданного");
        helpCommands.put("print_ascending:", "Вывести элементы коллекции в порядке возрастания");
        helpCommands.put("print_unique_nationality:", "вывести уникальные значения поля nationality всех элементов " +
                "в коллекции");
    }

    @Override
    public void help() {
        System.out.println("All commands: ");
        // Здесь должна быть сортировка

        Set<String> strings = helpCommands.keySet();
        for (String i : strings) {
            System.out.println(i + " " + helpCommands.get(i));
        }
    }

    @Override
    public void info() {
        try {
        System.out.println("Information about collection:");
        System.out.println("- Type of collection: Dequeue of Person");
        System.out.println("- Date of initializing: " + creation);
        System.out.println("- Count of elements: " + personCollection.size());
        System.out.println("- Author: Ivan Borisov");
        }
        catch (NullPointerException e){
            System.out.println("Коллекция не может быть пустой");
        }
    }

    @Override
    public void addFirst() throws IOException {
        Person person = new Person(getId(), askManager.askName(), askManager.askCoordinates(),
                askManager.askHeight(), askManager.askColor(), askManager.askCountry(), askManager.askLocation());
        System.out.println(person);
        personCollection.addFirst(person);
        System.out.println("element added");
    }

    @Override
    public void addLast() throws IOException {
        Person person = new Person(getId(), askManager.askName(), askManager.askCoordinates(),
                askManager.askHeight(), askManager.askColor(), askManager.askCountry(), askManager.askLocation());
        System.out.println(person);
        personCollection.addLast(person);
        System.out.println("element added");
    }


    @Override
    public void clear() {
        personCollection.clear();
        System.out.println("Коллекция очищена");
    }

    @Override
    public void removeFirst() {
        personCollection.removeFirst();
        System.out.println("Удален первый элемент коллекции");
    }

    @Override
    public void removeLast() {
        personCollection.removeLast();
        System.out.println("Удален последний элемент коллекции");
    }

    @Override
    public void addIfMax() throws IOException {
        Integer max = 0;
        for (Person person : personCollection){
            if (person.getHeight() > max){
                max = person.getHeight();
            }
        }

        Person person = new Person(getId(), askManager.askName(), askManager.askCoordinates(),
                askManager.askHeight(), askManager.askColor(), askManager.askCountry(), askManager.askLocation());

        if (person.getHeight() > max){
            personCollection.addLast(person);
            System.out.println("Элемент добавлен");
        }
        else {
            System.out.println("Элемент не добавлен, потому что не является максимальным");
        }
    }

    @Override
    public void filter_greater_than_height() {
        Integer height = askManager.askHeight();
        for (Person person : personCollection){
            if (person.getHeight() > height){
                System.out.println(person);
            }
        }
    }

    @Override
    public void print_ascending() {
        SortedSet<Person> set = new TreeSet<>();
        for (Person person : personCollection){
                set.add(person);
        }
        set.forEach(System.out::println);
    }

    @Override
    public void show() {
        for (Person person : personCollection){
                System.out.println(person);
        }
    }


    @Override
    public void save() throws IOException {
        OutputStream  os = new FileOutputStream("output.csv");
        Writer osr = new OutputStreamWriter(os);
        for (Person person : personCollection){
            osr.write(person.getName().toString() + ',' + person.getCoordinates().getX() + ',' +
                    person.getCoordinates().getY() + ',' + person.getCreationDate() + ',' +
                    person.getHeight() + ',' + person.getCountry().toString() + ',' +
                    person.getLocation().getX() + ',' + person.getLocation().getY());
        }
        osr.close();
        System.out.println("Коллекция сохранена");
    }

    @Override
    public void execute_script(String file_name) {
        String command;
        String[] finalCommad;
        try {
            System.out.println("Началось считывание файла "+ file_name);
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(file_name)));
            command = inputStreamReader.readLine();

            while (command != null) {
                finalCommad = command.trim().split(" ", 2);
                System.out.println("Сейчас идёт обработка команды "+ finalCommad[0]);
                switch (finalCommad[0]) {
                    case "help":
                        help();
                        break;
                    case "info":
                        info();
                        break;
                    case "show":
                        show();
                        break;
                    case "add":
                        addFirst();
                        break;
                    case "clear":
                        clear();
                        break;
                    case "exit":
                        break;
                    case "save":
                        save();
                        break;
                    case "execute_script":
                        if (finalCommad[1].equals(file_name)) throw new RecursiveCommandException();
                        execute_script(finalCommad[1]);
                        break;
                    default:
                        System.out.println("Команды "+finalCommad[0]+" не удалось обнаружить");
                }
                command = inputStreamReader.readLine();
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Файла не существует");
        }
        catch(IOException ex){
            System.out.println("Считывание невозможно");
        }
        catch (RecursiveCommandException ex){
            System.out.println("Команда вызывает саму себя - выполнение скрипта будет бесконечным");
        }
    }
}
