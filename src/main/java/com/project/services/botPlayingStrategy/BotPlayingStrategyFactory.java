package com.project.services.botPlayingStrategy;

import com.project.model.Board;
import com.project.model.Player;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
