package com.project.model;

import com.project.exceptions.InvalidBotCountException;
import com.project.exceptions.InvalidPlayerSizeException;
import com.project.exceptions.InvalidSymbolSetupException;
import com.project.services.winningStrategy.WinningStrategy;
import com.project.services.winningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board currentBoard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;

    private List<Move> moves;
    private List<Board> boardStatus;
    private WinningStrategy winningStrategy;
    private int numberOfSymbols;

    public Game(Board currentBoard, List<Player> players, WinningStrategyName winningStrategyName) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStatus = new ArrayList<>();
        this.winningStrategy = winningStrategy;
        this.numberOfSymbols = players.size();
    }
    public Builder builder(){
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStatus() {
        return boardStatus;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setBoardStatus(List<Board> boardStatus) {
        this.boardStatus = boardStatus;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public  static class Builder{
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStrategy winningStrategy;


        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }



        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }


        public  void validateNumberOfPlayers(){
            // N
            if(players.size() < currentBoard.getDimension() - 2 || players.size() >= currentBoard.getDimension()) {
                throw new InvalidPlayerSizeException("Player size should be N-1 or N-2 as per Board size");
            }
        }

        private void validatePlayerSymbols(){
            HashSet<Character> symbols = new HashSet<>();
            //TODO : Convert below code into lambda expressions
            for(Player player : players){
                symbols.add(player.getSymbol());
            }

            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbols for all the players");
            }
        }

        public void validateBotCount(){
            int botCount = 0;
            //TODO : Convert below code into lambda expressions
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount > 1 || botCount < 0){
                throw  new InvalidBotCountException("Bot count can't be greater than one or less than zero");
            }
        }

        public void validate(){
            validateNumberOfPlayers();
            validatePlayerSymbols();
            validateBotCount();
        }
        public Game build(){
            validate();
             return new Game(new Board(dimension), players, winningStrategy);
        }
    }
}
