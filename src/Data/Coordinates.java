package Data;

import Exceptions.OverflowXException;
import Exceptions.OverflowYException;

public class Coordinates {
    /**
     * The X.
     */
    private Long x;
    /**
     * The Y.
     */
    private Integer y;

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x coordinate.
     *
     * @return the x long
     */
    public Long getX() {
        return x;
    }

    /**
     * Sets x coordinate.
     *
     * @param x the x long
     */
    public void setX(Long x) throws OverflowXException {
        if (x > 613) throw new OverflowXException();
        this.x = x;
    }

    /**
     * Gets y coordinate.
     *
     * @return the y Double
     */
    public Integer getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y Double
     */
    public void setY(Integer y) throws OverflowYException {
        if (y > 962) throw new OverflowYException();
    }
}

