package state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class temporaryVariablesTest {

    @Test
    void getTempNewRow() {
        TemporaryVariables temp = new TemporaryVariables();
        assertFalse(temp.tempNewRow == 1);
    }


    @Test
    void getTempNewCol() {
        TemporaryVariables temp = new TemporaryVariables();
        assertTrue(temp.tempNewCol == 0);
    }

}