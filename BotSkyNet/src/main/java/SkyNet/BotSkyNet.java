package SkyNet;
import SkyNet.Command.*;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BotSkyNet extends TelegramLongPollingBot {
       private final HashMap<String, Command> map = new HashMap<>();
       private final BotMessage botMessage = new BotMessage();

    public BotSkyNet() {
        map.put("Surprise me!", new RandomMessage(botMessage));
        map.put("Mem!", new MemChackNorris());
        map.put("Next", new NextMessage(botMessage));
        map.put("Previous", new PreviousMessage(botMessage));
        map.put(null, new StartMessage(map));
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotSkyNet());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMsg(String chatId, Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(getCommand(update.getMessage().getText()));
        setButtons(sendMessage);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        String id = update.getMessage().getChatId().toString();
        sendMsg(id, update);
    }

    public String getBotUsername() {
        return "stationsAndMusicChartsBot";
    }

    public String getBotToken() {
        return "1003040463:AAEq4LnIrCYKMEyru-Tid0fY90cFNxc4Pas";
    }

    private String getCommand(String message){
        return map.get(map.containsKey(message)?message:null).execute();
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Surprise me!"));
        keyboardFirstRow.add(new KeyboardButton("Next"));
        keyboardFirstRow.add(new KeyboardButton("Previous"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Mem!"));
        keyboardSecondRow.add(new KeyboardButton("Help!"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

}
