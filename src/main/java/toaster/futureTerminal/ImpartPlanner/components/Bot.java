package toaster.futureTerminal.ImpartPlanner.components;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        var msgId = msg.getMessageId();
        var user = msg.getFrom();
        var userId  = user.getId();

        if (msg.isCommand()) {
            if (msg.getText().equals("/start")) {
                sendText(userId, "This is a bot that is work in progress that helps people make plans :)");
            }
        }
    }

    /*
    Send message directly to the user
     */
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public void copyMessage(Long who, Integer msgId){
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(who.toString())  //We copy from the user
                .chatId(who.toString())      //And send it back to him
                .messageId(msgId)            //Specifying what message
                .build();
        try {
            execute(cm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
