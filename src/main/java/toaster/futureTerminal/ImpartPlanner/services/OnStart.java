package toaster.futureTerminal.ImpartPlanner.services;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import toaster.futureTerminal.ImpartPlanner.components.Bot;

@Service
public class OnStart {

    private static final Logger onStartLogger = LoggerFactory.getLogger(OnStart.class);
    @EventListener(ApplicationReadyEvent.class)
    public void runOnStart(){
        onStartLogger.warn("OnStart is running...");
        System.out.println("sys, OnStart is running...");
        //buildBot();
    }

    private void buildBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }
}
