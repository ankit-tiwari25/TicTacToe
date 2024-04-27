package com.project;

import com.project.model.Bot;
import com.project.model.BotDifficultyLevel;
import com.project.model.Player;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TicTacToe {
    public static void main(String[] args) {
        int id = 1;
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
        }
    }
}