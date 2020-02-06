package SkyNet;

import SkyNet.Command.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BotSkyNet extends TelegramLongPollingBot {
    private final HashMap<String, Command> map = new HashMap<>();
    private final BotMessageRepository botMessageRepository = new BotMessageRepository();

    public BotSkyNet() {
        map.put("Surprise me!", new RandomMessage(botMessageRepository));
        map.put("Mem!", new MemChackNorris());
        map.put("Next", new NextMessage(botMessageRepository));
        map.put("Previous", new PreviousMessage(botMessageRepository));
        map.put("Help!", new StartMessage(map));
    }


    public void sendMsg(String chatId, Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        String message = update.getMessage().getText();
        if ((chatId.contains("954767511")) && (message.contains("/add -author=")) && (message.contains("-message="))) {
            message = doCommand(botMessageRepository.addAuthorMessageToBase(message));
            sendMessage.setText(message);
        } else {
            message=doCommand(message);
            sendMessage.setText(message);
        }
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

    private String doCommand(String message) {
        if (map.containsKey(message)) {
            return map.get(message).execute();
        } else {
            return botMessageRepository.thisIsAuthorOrMessage(message);
        }
    }

    public void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Surprise me!"));
        keyboardFirstRow.add(new KeyboardButton("Next"));
        keyboardFirstRow.add(new KeyboardButton("Previous"));
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add(new KeyboardButton("Mem!"));
        keyboardSecondRow.add(new KeyboardButton("Help!"));
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

}
