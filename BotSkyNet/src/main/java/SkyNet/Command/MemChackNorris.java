package SkyNet.Command;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MemChackNorris implements Command {

    @Override
    public String execute() {
        HttpResponse<String> response = null;
        HttpResponse<String> responseTranslation = null;

        try {
            response = Unirest.get("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random")
                    .header("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", "77b26de0b4msh6f07032a5f1c12fp14d20cjsnf6667015e207")
                    .header("accept", "application/json")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
}
