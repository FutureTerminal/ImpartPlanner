package toaster.futureTerminal.ImpartPlanner.components;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "ImpartPlanner_bot";
    }

    @Override
    public String getBotToken() {
        return "6098000257:AAFMPBRfAtJaNczpfjbeljun92yJKXARj1Q";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();

        System.out.println(user.getUserName() + " wrote " + msg.getText());
    }
}
