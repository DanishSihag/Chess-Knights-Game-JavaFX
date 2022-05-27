package state;

/**
 * Represents the 4 type of objects that correspond to the game.
 */
public enum Square {

    /**
     * Represents a square object that is empty.
     */
    EMPTY,

    /**
     * Represents the black knight object.
     */
    BLACK_KNIGHT,

    /**
     * Represents the white knight object.
     */
    WHITE_KNIGHT,

    /**
     * Represents a painted circle that shows positions which are valid for movements corresponding to the knights.
     */
    VALID_CIRCLE
}
