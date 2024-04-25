package com.project.services.winningStrategy;

import com.project.model.Board;
import com.project.model.Move;
import com.project.model.Player;

public interface WinningStrategy {
    public Player checkWinner(Board board, Move lastMove);
}
