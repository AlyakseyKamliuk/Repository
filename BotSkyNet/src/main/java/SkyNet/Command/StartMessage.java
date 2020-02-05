package SkyNet.Command;

import java.util.HashMap;
import java.util.Map;

public class StartMessage implements Command {
    private HashMap<String, Command> map = null;

    public StartMessage(HashMap<String, Command> map) {
        this.map = map;
    }


    @Override
    public String execute() {
        Help help=new Help();
        HashMap<String,String> helpMap=help.createMap();
        String commands = "Приветсвую! Я бот SkyNet версия 1.1. \nЯ предоставляю мемы, или знаменитые высказывания Великих людей!\nСписок команд: \n";
        for (Map.Entry<String, Command> p : map.entrySet()) {
            commands += p.getKey() == null ? "Любое сообщение    -     "+helpMap.get(null)+".\n" : p.getKey() + "  -   "+helpMap.get(p.getKey())+".\n";
        }
        return commands;
    }
}
