package SkyNet.Command;

import java.util.HashMap;

public class Help {

    public HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Удиви меня!", "Выводит случайное высказывание случайного автора");
        map.put("Surprise me!", "Outputs a random statement from a random author");
        map.put("Mem!", "Random meme about Chuck Norris");
        map.put("Next", "Returns the following message from the author");
        map.put("Previous", "Returns the author's previous message");
        map.put(null, "Help");
        return map;
    }
}
