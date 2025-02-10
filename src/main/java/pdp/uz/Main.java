package pdp.uz;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import pdp.uz.bot.FakerBotService;

public class Main {
    public static void main(String[] args) {
        String botToken = "7640690721:AAHEKSN_NNDiScR2uVkQ-Jo__RCEG8DWqeU";

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            FakerBotService bot = new FakerBotService(botToken);
            botsApi.registerBot(bot);
            System.out.println("🤖 Бот успешно запущен!");
        } catch (TelegramApiException e) {
            System.err.println("❌ Ошибка запуска бота: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
