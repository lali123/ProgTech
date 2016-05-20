package hu.unideb.inf.lali123.model;

import javafx.scene.shape.Circle;

/**
 * This class extends the Circle class with 2 field: column, row.
 * 
 * @author Lajos
 *
 */
public class Disc extends Circle {
    private int column, row;

    /**
     * Construct the Disc.
     * 
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
     * Get the column of the disk.
     * 
     * @return
     */
    public int getcolumn() {
        return column;
    }

    /**
     * Get the row of the disk.
     * 
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Set the column of the disk.
     * 
     * @param column
     */
    public void setcolumn(int column) {
        this.column = column;
    }

    /**
     * Set the row of the disk.
     * 
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

}
