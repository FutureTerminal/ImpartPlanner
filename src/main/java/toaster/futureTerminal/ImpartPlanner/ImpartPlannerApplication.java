package toaster.futureTerminal.ImpartPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class ImpartPlannerApplication {

	public static void main(String[] args) {
		//TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		//botsApi.registerBot(new Bot());
		SpringApplication.run(ImpartPlannerApplication.class, args);
	}

}