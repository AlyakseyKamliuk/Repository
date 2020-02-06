package SkyNet.Command;

import SkyNet.BotMessageRepository;

public class PreviousMessage implements Command {
    BotMessageRepository botMessageRepository =null;

    public PreviousMessage(BotMessageRepository botMessageRepository) {
        this.botMessageRepository = botMessageRepository;
    }

    @Override
    public String execute() {
        return botMessageRepository.previous();
    }
}
