package SkyNet;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.HashMap;

public class HelperMethod {

    public String help(HashMap<String, Command> map) {
        HashMap<String, String> helpMap = createMap();
        String[] commands = {"Приветсвую! Я бот SkyNet версия 1.1. \nЯ предоставляю мемы, или знаменитые высказывания Великих людей!\nСписок команд: \n"};
        map.entrySet().stream().forEach(p -> commands[0] +=  p.getKey() + "  -   " + helpMap.get(p.getKey()) + ".\n");
        return commands[0];
    }

    public String memChackNorris() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random")
                    .header("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "77b26de0b4msh6f07032a5f1c12fp14d20cjsnf6667015e207")
                    .header("accept", "application/json")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody().substring(response.getBody().indexOf("value") + 8, response.getBody().lastIndexOf("}") - 1);
    }

    private HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Удиви меня!", "Выводит случайное высказывание случайного автора");
        map.put("Surprise me!", "Outputs a random statement from a random author");
        map.put("Mem!", "Random meme about Chuck Norris");
        map.put("Next", "Returns the following message from the author");
        map.put("Previous", "Returns the author's previous message");
        map.put("Help!", "Help");
        map.put("Save", "Adding records to the database (only for admins)");
        return map;
    }
}