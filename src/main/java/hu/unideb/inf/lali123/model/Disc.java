package hu.unideb.inf.lali123.model;

import javafx.scene.shape.Circle;

/**
 * @author Lajos
 *
 */
public class Disc extends Circle {
    private int column, row;

    /**
     * @param radius
     * @param column
     * @param row
     */
    public Disc(double radius, int column, int row) {
        super(radius);
        this.column = column;
        this.row = row;
    }

    /**
     * @return
     */
    public int getcolumn() {
        return column;
    }

    /**
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * @param column
     */
    public void setcolumn(int column) {
        this.column = column;
    }

    /**
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

}
