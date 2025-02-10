package pdp.uz.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pdp.uz.service.CapitalService;
import pdp.uz.service.EmployeeService;
import pdp.uz.service.MyCountryService;
import pdp.uz.service.StudentService;
import pdp.uz.util.TelegramUtil;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Avazbek on 10/02/25 10:33
 */
public class FakerBotService extends TelegramLongPollingBot {
    final String EMPLOYEE = "Xodimlar"; // yes
    final String STUDENT = "Talabalar";
    final String COUNTRY = "Davlatlar"; // yes
    final String CAPITAL = "Poytaxtlar";


    public FakerBotService(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            processMessage(update.getMessage());
        }

    }

    @Override
    public String getBotUsername() {
        return "@fakercheckingbot";
    }

    private void processMessage(Message message) {
        String text = message.getText();
        switch (text) {
            case "/start" -> userStart(message);
            case EMPLOYEE -> generateEmployee(message);
            case COUNTRY -> generateCountry(message);
            case CAPITAL -> generateCapital(message);
            case STUDENT -> generateStudent(message);
        }
    }

    private void userStart(Message message) {
        Long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage(
                chatId.toString(),
                "Добро пожаловать в телеграм-бот! Выберите один из вариантов 👇🏼"
        );

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setSelective(true);
        keyboard.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(EMPLOYEE);
        row1.add(STUDENT);
        rows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(COUNTRY);
        row2.add(CAPITAL);
        rows.add(row2);

        keyboard.setKeyboard(rows);
        sendMessage.setReplyMarkup(keyboard);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateEmployee(Message message) {
        String fileName = EmployeeService.generateEmployees(50);
        TelegramUtil.sendDocument(this, message.getChatId(), fileName);
    }

    private void generateStudent(Message message) {
        String fileName = StudentService.generateStudents(50);
        TelegramUtil.sendDocument(this, message.getChatId(), fileName);
    }

    private void generateCountry(Message message) {
        String fileName = MyCountryService.generateCountries(50);
        TelegramUtil.sendDocument(this, message.getChatId(), fileName);
    }

    private void generateCapital(Message message) {
        String fileName = CapitalService.generateCapitals(50);
        TelegramUtil.sendDocument(this, message.getChatId(), fileName);
    }
}
