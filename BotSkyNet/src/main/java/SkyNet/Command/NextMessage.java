package SkyNet.Command;

import SkyNet.BotMessageRepository;

public class NextMessage implements Command {
    BotMessageRepository botMessageRepository =null;

    public NextMessage(BotMessageRepository botMessageRepository) {
        this.botMessageRepository = botMessageRepository;
    }

    @Override
    public String execute() {
      return botMessageRepository.next();
    }
}
