package toaster.futureTerminal.ImpartPlanner.services;

import org.springframework.stereotype.Service;
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
        onStartLogger.info("OnStart is running...");
        try {
            buildBot();
        } catch (Exception exception) {
            onStartLogger.error("Bot is not built");
        }
        onStartLogger.info("OnStart is finished");
    }

    private void buildBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot());
    }
}
