package com.project.controller;

import com.project.model.*;
import com.project.services.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, WinningStrategy winningStrategy){

        return null;
    }
    public void displayBoard(Game game){
        game.getCurrentBoard().dislayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return null;
    }
    public  Player getWinner(Game game){
        return null;
    }
    public Move executeMove(Game game, Player player){
        return  null;
    }

    public  Player checkWinner(Game game, Move lastPlayedMove){
        return null;
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }

    public  void ReplayGame(Game game){

    }
}
