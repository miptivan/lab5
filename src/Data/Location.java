package Data;

import Exceptions.OverflowXException;

public class Location {
    private Long x;  // Поле не может быть null
    private double y;
    private String name;  // Длина строки не должна быть больше 929, Поле не может быть null

    public Location(Long x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void setX(Long x) throws OverflowXException {
        if (x == null) throw new NullPointerException();
        this.x = x;
    }

    public void setY(double y) throws OverflowXException {
        try {
            this.y = y;
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
        }
    }

    public Long getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
