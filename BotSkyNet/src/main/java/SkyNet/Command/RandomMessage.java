package SkyNet.Command;

import SkyNet.BotMessage;

public class RandomMessage implements Command {

    BotMessage botMessage=null;

    public RandomMessage(BotMessage botMessage) {
        this.botMessage = botMessage;
    }

    @Override
    public String execute() {
       return botMessage.getMessage(true,0);
    }
}
