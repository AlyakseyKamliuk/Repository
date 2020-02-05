package SkyNet.Command;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.URLEncoder;

public class YandexInterpreter implements Command {
    private String text = "Test";

    public YandexInterpreter(String text) {
        this.text = text;
    }

    @Override
    public String execute() {

        HttpResponse<String> responseTranslation = null;
        String test=URLEncoder.encode("Test");

        try {
            responseTranslation = Unirest.get("https://translate.yandex.net/api/v1.5/tr.json/translate+" +
                    "?key=trnsl.1.1.20200204T170530Z.723543744eebd4f2.40724c15ea7e203753c885d66c3f11b79fc6d5d5" +
                    "&text=" + test+
                    "&lang=en-ru" +
                    "&format=plain" +
                    "&options=1")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return responseTranslation.getBody();
    }
}
