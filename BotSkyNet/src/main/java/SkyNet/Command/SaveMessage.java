package SkyNet.Command;

import SkyNet.BotMessageRepository;

public class SaveMessage implements Command {
    private BotMessageRepository botMessageRepository =null;
    private String message="";

    public SaveMessage(BotMessageRepository botMessageRepository, String message) {
        this.botMessageRepository = botMessageRepository;
        this.message=message;
    }

    @Override
    public String execute() {
        return botMessageRepository.saveMessage(message);
    }

}
