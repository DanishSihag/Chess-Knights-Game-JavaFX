package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class boardGameModelTest {


    @Test
    void isValidPositionShowing() {

        boardGameModel board = new boardGameModel();
        assertFalse(board.isValidPositionShowing());
    }

}