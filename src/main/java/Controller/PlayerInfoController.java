package Controller;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class PlayerInfoController {

    private String playerName;

    private int numberOfMoves;

    private LocalDateTime timeAtStart;

    private LocalDateTime timeAtFinish;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
}
