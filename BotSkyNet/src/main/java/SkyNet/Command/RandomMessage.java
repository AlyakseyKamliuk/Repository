package SkyNet.Command;

import SkyNet.BotMessageRepository;

public class RandomMessage implements Command {

    BotMessageRepository botMessageRepository =null;

    public RandomMessage(BotMessageRepository botMessageRepository) {
        this.botMessageRepository = botMessageRepository;
    }

    @Override
    public String execute() {
       return botMessageRepository.getMessage(true,0);
    }
}
