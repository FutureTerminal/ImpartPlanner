package toaster.futureTerminal.ImpartPlanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import toaster.futureTerminal.ImpartPlanner.components.Bot;

@Service
public class OnStart {

    private static final Logger onStartLogger = LoggerFactory.getLogger(OnStart.class);
    private Bot bot;

    @Autowired
    public OnStart(Bot bot) {
        this.bot = bot;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStart() throws TelegramApiException {
        onStartLogger.info("OnStart is running...");
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(bot);
        } catch (Exception exception) {
            onStartLogger.error("Bot is not built", exception);
        }
        onStartLogger.info("OnStart is finished");
    }
}
