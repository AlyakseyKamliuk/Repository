package SkyNet;

import java.util.HashMap;

public class ExecutableCommands {
    private final HashMap<String, Command> map = new HashMap<>();
    private final HelperMethod helperMethod = new HelperMethod();
    private final BotMessageRepository botMessageRepository = new BotMessageRepository();
    private String message = "";

    public ExecutableCommands() {
        map.put("Surprise me!", () -> botMessageRepository.getMessage(true, 0));
        map.put("Mem!", helperMethod::memChackNorris);
        map.put("Next", botMessageRepository::next);
        map.put("Previous", botMessageRepository::previous);
        map.put("Help!", () -> helperMethod.help(map));
        map.put("Save", () -> botMessageRepository.saveMessage(message));
    }

    public String doCommand(String chatId, String message) {
        this.message = message;
        return map.containsKey(message) && !message.contains("Save") ? map.get(message).execute() :
                ((chatId.contains("954767511")) && (message.contains("/add -author=")) && (message.contains("-message="))) ? map.get("Save").execute() : botMessageRepository.findMessage(message);
    }
}
