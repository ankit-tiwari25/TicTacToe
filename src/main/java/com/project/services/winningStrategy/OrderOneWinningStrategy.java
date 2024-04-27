package com.project.services.winningStrategy;

import com.project.model.Board;
import com.project.model.Cell;
import com.project.model.Move;
import com.project.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<HashMap<Character, Integer>> rowHashMapList; // List Index -> row no for HashMap Identification
    private List<HashMap<Character,Integer>> colHashMapsList;
    private HashMap<Character,Integer> leftDiagonal;
    private HashMap<Character,Integer> rightDiagonal;

    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapsList = new ArrayList<>();
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        for(int i = 0; i < dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapsList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        Player player = lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winnerResult = winnerCheckForCorners(board.getMatrix(), symbol)
                || checkAndUpdateForRowHashMap(row, symbol)
                || checkAndUpdateForColHashMap(col, symbol)
                || (checkLeftDiagonal(row,col) && checkAndUpdateLeftDiagonalHashMap(symbol))
                || (checkRightDiagonal(row,col) && checkAndUpdateForRightDiagonal(symbol));

        if(winnerResult){
            return player;
        }
        return null;
    }

    private boolean checkLeftDiagonal(int row, int col){
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col){
        return ((row + col )== (dimension -1));
    }
    public boolean checkAndUpdateForRowHashMap(int row, char symbol){
        HashMap<Character, Integer> rowHashMap = rowHashMapList.get(row);
        if(rowHashMap.containsKey(symbol)){
            rowHashMap.put(symbol, rowHashMap.get(symbol) + 1);
            return  rowHashMap.get(symbol) == dimension;
        }else {
            rowHashMap.put(symbol,1);
        }
        return false;
    }

    public boolean checkAndUpdateForColHashMap(int col, char symbol){
        HashMap<Character, Integer> colHashMap = colHashMapsList.get(col);
        if(colHashMap.containsKey(symbol)){
            colHashMap.put(symbol,colHashMap.get(symbol) + 1);
            return colHashMap.get(symbol) == dimension;
        }else{
            colHashMap.put(symbol,1);
        }

        return false;
    }

    public  boolean checkAndUpdateLeftDiagonalHashMap(char symbol){
        if(leftDiagonal.containsKey(symbol)){
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
            return leftDiagonal.get(symbol) == dimension;
        }else{
            leftDiagonal.put(symbol,1);
        }
        return false;
    }

    public boolean checkAndUpdateForRightDiagonal(char symbol){
        if(rightDiagonal.containsKey(symbol)){
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
            return  rightDiagonal.get(symbol) == dimension;
        }else {
            rightDiagonal.put(symbol,1);
        }
        return false;
    }

    public boolean winnerCheckForCorners(List<List<Cell>> matrix, char symbol){

        return (matrix.get(0).get(0).getPlayer().getSymbol() == symbol)
                && (matrix.get(0).get(dimension - 1).getPlayer().getSymbol() == symbol)
                && (matrix.get(dimension - 1).get(0).getPlayer().getSymbol() == symbol)
                && (matrix.get(dimension - 1).get(dimension - 1).getPlayer().getSymbol() == symbol);
    }
}
