package SkyNet.Command;

import SkyNet.BotMessage;

public class NextMessage implements Command {
    BotMessage botMessage=null;

    public NextMessage(BotMessage botMessage) {
        this.botMessage = botMessage;
    }

    @Override
    public String execute() {
      return botMessage.next();
    }
}
