package state;

/**
 * Represents a class that contains two temporary variables, one for row and other for column,
 * initialized with getter and setter methods.
 * The variables reset value everytime they are called in the Mouse Handle method of GameController class.
 */
public class temporaryVariables {
    /**
     * Represents the temporary Row value, initialized as 0 or empty.
     */
    public int tempNewRow = 0;

    /**
     * Represents the temporary Column value, initialized as 0 or empty.
     */
    public int tempNewCol = 0;

    /**
     * Getter method for temporary row value.
     *
     * {@return the temporary row value.}
     */
    public int getTempNewRow(){
        return tempNewRow;
    }

    /**
     * Setter method for temporary row value.
     *
     * @param tempNewRow the temporary Row value.
     */
    public void setTempNewRow(int tempNewRow) {
        this.tempNewRow = tempNewRow;
    }

    /**
     * Getter method for temporary column value.
     *
     * {@return the temporary column value.}
     */
    public int getTempNewCol() {
        return tempNewCol;
    }

    /**
     * Setter method for temporary column value.
     *
     * @param tempNewCol the temporary Column value.
     */
    public void setTempNewCol(int tempNewCol) {
        this.tempNewCol = tempNewCol;
    }
}
