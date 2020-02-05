package SkyNet.Command;

import SkyNet.BotMessage;

public class PreviousMessage implements Command {
    BotMessage botMessage=null;

    public PreviousMessage(BotMessage botMessage) {
        this.botMessage = botMessage;
    }

    @Override
    public String execute() {
        return botMessage.previous();
    }
}
