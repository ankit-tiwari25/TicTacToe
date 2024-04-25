package com.project.model;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;



    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "ROBO", symbol,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
    @Override
    public Move makeMove(){
        return null;
    }
}
