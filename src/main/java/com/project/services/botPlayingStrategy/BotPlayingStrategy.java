package com.project.services.botPlayingStrategy;

import com.project.model.Board;
import com.project.model.Move;
import com.project.model.Player;

public interface BotPlayingStrategy {
    Move makeMove(Board board, Player player);
}
