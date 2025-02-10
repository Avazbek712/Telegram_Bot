package pdp.uz.util;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

/**
 * Created by Avazbek on 10/02/25 18:17
 */
public class TelegramUtil {
    public static void sendDocument(TelegramLongPollingBot bot, Long chatId, String fileName) {
        SendDocument sendDocument = new SendDocument(
                chatId.toString(),
                new InputFile(new File(fileName))
        );
        try {
            bot.execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Ошибка при отправке документа: " + fileName, e);
        }
    }
}
