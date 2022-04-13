package Data;

import java.util.Date;

public class Person implements Comparable<Person> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer height; //Поле может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime birthday; //Поле может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(int id, String name, Coordinates coordinates, Integer height, Color hairColor, Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.height = height;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets height.
     *
     * @return the integer
     */
    public Integer getHeight(){
        return height;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Gets hair color.
     *
     * @return color
     */
    public Color getHairColor() { return hairColor; }

    /**
     * Gets country.
     *
     * @return country
     */
    public Country getCountry() {
        return nationality;
    }

    /**
     * Gets location.
     *
     * @return Location
     */
    public Location getLocation() { return location; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Sets Country.
     *
     * @param Country Country
     */
    public void setType(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return  "Person{" +
                "id = " + id +
                "; name = " + name + '\'' +
                "; coordinates X = " + coordinates.getX() +
                "; coordinates Y = " + coordinates.getY() +
                "; creationDate = " + creationDate +
                "; height = " + height +
                "; country = " + nationality +
                "; location = " + location +
                "}" + "\n";
    }

    @Override
    public int compareTo(Person p) {
        return this.name.length() - p.name.length();
    }
}
