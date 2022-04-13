package Data;

import Exceptions.OverflowXException;

/**
 * The type Location.
 */
public class Location {
    private Long x;  // Поле не может быть null
    private double y;
    private String name;  // Длина строки не должна быть больше 929, Поле не может быть null

    /**
     * Instantiates a new Location.
     *
     * @param x    the x
     * @param y    the y
     * @param name the name
     */
    public Location(Long x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Sets x.
     *
     * @param x the x
     * @throws OverflowXException the overflow x exception
     */
    public void setX(Long x) throws OverflowXException {
        if (x == null) throw new NullPointerException();
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     * @throws OverflowXException the overflow x exception
     */
    public void setY(double y) throws OverflowXException {
        try {
            this.y = y;
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
        }
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public Long getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return y;
    }
}
