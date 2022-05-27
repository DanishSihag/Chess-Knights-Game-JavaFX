package state;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.Alert;
import org.tinylog.Logger;

/**
 * Class representing the model/state of the board game.
 */
public class boardGameModel {

    /**
     * The size of the board.
     */
    public static int BOARD_SIZE = 4;

    private ReadOnlyObjectWrapper<Square>[][] board = new ReadOnlyObjectWrapper[BOARD_SIZE][BOARD_SIZE - 1];

    /**
     * Integer value that corresponds to the number of moves made by the player.
     */
    public int numberOfMoves = 0;

    /**
     * Creates {@code boardGameModel} object that corresponds to the initial state of the game.
     */
    public boardGameModel() {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE - 1; j++) {

                if (i == 0){
                    board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.BLACK_KNIGHT);;
                }else if (i == 3){
                    board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.WHITE_KNIGHT);
                } else {
                    board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.EMPTY);
                }
            }
        }
    }

    /**
     * Creates {@code validMoves} that corresponds to all the valid moves that can be made by the chess knights,
     * with respect to their specific position on the board.
     *
     * @param row the number of the specific row corresponding to the board.
     * @param col the number of the specific column corresponding to the board.
     */
    public void validMoves(int row, int col) {
        if (row == 0 && col == 0) {
            if (board[row + 2][col + 1].get() == Square.EMPTY) {
                board[row + 2][col + 1].set(Square.VALID_CIRCLE);
            }
            if (board[row + 1][col + 2].get() == Square.EMPTY) {
                board[row + 1][col + 2].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 1 && col == 0) {
                if (board[row - 1][col + 2].get() == Square.EMPTY) {
                    board[row - 1][col + 2].set(Square.VALID_CIRCLE);
                }
                if (board[row + 1][col + 2].get() == Square.EMPTY) {
                    board[row + 1][col + 2].set(Square.VALID_CIRCLE);
                }
                if (board[row + 2][col + 1].get() == Square.EMPTY) {
                    board[row + 2][col + 1].set(Square.VALID_CIRCLE);
                }
            }
        else if (row == 2 && col == 0){
            if (board[row - 2][col + 1].get() == Square.EMPTY) {
                board[row - 2][col + 1].set(Square.VALID_CIRCLE);
            }
            if (board[row - 1][col + 2].get() == Square.EMPTY) {
                board[row - 1][col + 2].set(Square.VALID_CIRCLE);
            }
            if (board[row + 1][col + 2].get() == Square.EMPTY) {
                board[row + 1][col + 2].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 3 && col == 0){
            if (board[row - 1][col + 2].get() == Square.EMPTY) {
                board[row - 1][col + 2].set(Square.VALID_CIRCLE);
            }
            if (board[row - 2][col + 1].get() == Square.EMPTY) {
                board[row - 2][col + 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 0 && col == 1){
            if (board[row + 2][col - 1].get() == Square.EMPTY) {
                board[row + 2][col - 1].set(Square.VALID_CIRCLE);
            }
            if (board[row + 2][col + 1].get() == Square.EMPTY) {
                board[row + 2][col + 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 1 && col == 1){
            if (board[row + 2][col - 1].get() == Square.EMPTY) {
                board[row + 2][col - 1].set(Square.VALID_CIRCLE);
            }
            if (board[row + 2][col + 1].get() == Square.EMPTY) {
                board[row + 2][col + 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 2 && col == 1){
            if (board[row - 2][col - 1].get() == Square.EMPTY) {
                board[row - 2][col - 1].set(Square.VALID_CIRCLE);
            }
            if (board[row - 2][col + 1].get() == Square.EMPTY) {
                board[row - 2][col + 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 3 && col == 1){
            if (board[row - 2][col - 1].get() == Square.EMPTY) {
                board[row - 2][col - 1].set(Square.VALID_CIRCLE);
            }
            if (board[row - 2][col + 1].get() == Square.EMPTY) {
                board[row - 2][col + 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 0 && col == 2){
            if (board[row + 1][col - 2].get() == Square.EMPTY) {
                board[row + 1][col - 2].set(Square.VALID_CIRCLE);
            }
            if (board[row + 2][col - 1].get() == Square.EMPTY) {
                board[row + 2][col - 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 1 && col == 2){
            if (board[row - 1][col - 2].get() == Square.EMPTY) {
                board[row - 1][col - 2].set(Square.VALID_CIRCLE);
            }
            if (board[row + 1][col - 2].get() == Square.EMPTY) {
                board[row + 1][col - 2].set(Square.VALID_CIRCLE);
            }
            if (board[row + 2][col - 1].get() == Square.EMPTY) {
                board[row + 2][col - 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 2 && col == 2){
            if (board[row - 1][col - 2].get() == Square.EMPTY) {
                board[row - 1][col - 2].set(Square.VALID_CIRCLE);
            }
            if (board[row + 1][col - 2].get() == Square.EMPTY) {
                board[row + 1][col - 2].set(Square.VALID_CIRCLE);
            }
            if (board[row - 2][col - 1].get() == Square.EMPTY) {
                board[row - 2][col - 1].set(Square.VALID_CIRCLE);
            }
        }
        else if (row == 3 && col == 2){
            if (board[row - 2][col - 1].get() == Square.EMPTY) {
                board[row - 2][col - 1].set(Square.VALID_CIRCLE);
            }
            if (board[row - 1][col - 2].get() == Square.EMPTY) {
                board[row - 1][col - 2].set(Square.VALID_CIRCLE);
            }
        }
    }

    public ReadOnlyObjectProperty<Square> squareProperty(int i, int j) {
        return board[i][j].getReadOnlyProperty();
    }

    /**
     * {@return The exact position of the square corresponding to the board, in sense of row and column.}
     *
     * @param i the number of the specific row corresponding to the board.
     * @param j the number of the specific column corresponding to the board.
     */
    public Square getSquare(int i, int j) {
        return board[i][j].get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE - 1; j++) {
                sb.append(board[i][j].get().ordinal()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * {@return true if the the VALID_CIRCLE enum is being shown on the board.}
     */
    public boolean isValidPositionShowing(){

        for (var i = 0; i<BOARD_SIZE; i++) {
            for (var j = 0; j<BOARD_SIZE-1; j++) {
                if (board[i][j].get() == Square.VALID_CIRCLE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Creates {@code validCircleRemover} that makes all the squares of the board containing chess knight objects empty,
     * if it is not empty already, in that case also, it is made empty.
     * Also calls the isValidPositionShowing method and if the value is true, this method is used.
     */
    public void validCircleRemover() {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE - 1; j++){
                if (board[i][j].get() != Square.BLACK_KNIGHT && board[i][j].get() != Square.WHITE_KNIGHT && board[i][j].get() != Square.EMPTY){
                    board[i][j].set(Square.EMPTY);
                    isValidPositionShowing();
                }
            }
        }
    }

    /**
     * Creates {@code moveKnights} in which the 1st two parameters correspond to the position of the black Knights or white Knights
     * and the other two parameters correspond to checking the position that is valid, if this check is satisfied,
     * the black or white knights are set to this new position.
     * Also, increments the number of moves by 1 for each time the method is called.
     *
     * @param newRowKnights the row corresponding to the position of the black or white knight.
     * @param newColKnights the column corresponding to the position of the black or white knight.
     * @param newRowValidCircle the row corresponding to the position of the VALID_CIRCLE enum.
     * @param newColValidCircle the column corresponding to the position of the VALID_CIRCLE enum.
     */
    public void moveKnights(int newRowKnights, int newColKnights, int newRowValidCircle, int newColValidCircle) {

        if (board[newRowKnights][newColKnights].get() == Square.BLACK_KNIGHT) {
            if (board[newRowValidCircle][newColValidCircle].get() == Square.VALID_CIRCLE) {
                board[newRowValidCircle][newColValidCircle].set(Square.BLACK_KNIGHT);

                numberOfMoves++;
            }
        }
            else if(board[newRowKnights][newColKnights].get() == Square.WHITE_KNIGHT){
                if (board[newRowValidCircle][newColValidCircle].get() == Square.VALID_CIRCLE){
                    board[newRowValidCircle][newColValidCircle].set(Square.WHITE_KNIGHT);

                    numberOfMoves++;
                }
            }
           board[newRowKnights][newColKnights].set(Square.EMPTY);
    }

    /**
     *{@return true if the goal state has been reached corresponding to position of black and white knights.}
     */
    public boolean goalStateReached() {

        var alert = new Alert(Alert.AlertType.INFORMATION);

        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE - 1; j++) {
                if (board[0][0].get() == Square.WHITE_KNIGHT && board[0][1].get() == Square.WHITE_KNIGHT && board[0][2].get() == Square.WHITE_KNIGHT
                        && board[3][0].get() == Square.BLACK_KNIGHT && board[3][1].get() == Square.BLACK_KNIGHT && board[3][2].get() == Square.BLACK_KNIGHT){
                    alert.setContentText("Congratulations! You have completed the game.");
                    alert.showAndWait();
                    validCircleRemover();
                    Logger.info("Goal state reached.");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var model = new boardGameModel();
        System.out.println(model);
    }
}
