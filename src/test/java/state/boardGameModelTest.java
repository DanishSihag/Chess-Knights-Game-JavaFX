package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class boardGameModelTest {


    @Test
    void isValidPositionShowing() {

        BoardGameModel board = new BoardGameModel();
        assertFalse(board.isValidPositionShowing());
    }

}