package com.project.services.botPlayingStrategy;

import com.project.exceptions.GameOverException;
import com.project.model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements  BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrix = board.getMatrix();

        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.size(); j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    matrix.get(i).get(j).setCellState(CellState.FILLED);;
                    matrix.get(i).get(i).setPlayer(bot);

                    return new Move(board.getMatrix().get(i).get(j), bot);
                }
            }
        }
        throw new GameOverException("No empty cells on the board");
    }
}
