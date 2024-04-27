package com.project;

import com.project.controller.GameController;
import com.project.model.*;
import com.project.services.winningStrategy.WinningStrategy;
import com.project.services.winningStrategy.WinningStrategyName;

import java.sql.SQLSyntaxErrorException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToe {
    public static void main(String[] args) {
        int id = 1;
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe Game");
        System.out.println("Please enter the dimensions of board");
        int dimension = sc.nextInt();

        System.out.println("Do you want a bot? Y/N");
        String botAns = sc.next();

        if(botAns.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++, 'B', BotDifficultyLevel.HARD);
            players.add(bot);
        }

        while(id < dimension){
            System.out.println("Please enter player name : ");
            String name = sc.next();
            System.out.println("Please enter player symbol");
            char symbol = sc.next().charAt(0);

            Player newPlayer = new Player(id++, name, symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        Collections.shuffle(players);
        Game game = new Game(dimension,players, WinningStrategyName.ORDERONEWINNINGSTRATEGY);
        int playerIndex = -1;
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current Board Status");
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            Move movePlayed = gameController.executeMove(game, players.get(playerIndex));
            Player winner = gameController.checkWinner(game, movePlayed);
            if(winner!= null){
                System.out.println("WINNER IS : "+ winner.getName());
            }
        }

        System.out.println("FINAL BOARD STATUS : ");
        gameController.displayBoard(game);
    }
}