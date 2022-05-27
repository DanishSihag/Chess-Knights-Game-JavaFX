package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class temporaryVariablesTest {

    @Test
    void getTempNewRow() {
        temporaryVariables temp = new temporaryVariables();
        assertFalse(temp.tempNewRow == 1);
    }


    @Test
    void getTempNewCol() {
        temporaryVariables temp = new temporaryVariables();
        assertTrue(temp.tempNewCol == 0);
    }

}