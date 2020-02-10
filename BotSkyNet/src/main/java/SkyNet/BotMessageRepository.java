package SkyNet;
import java.util.ArrayList;

public class BotMessageRepository {
    private int indexMessage = 0;
    private SQLConnection sqlConnection=new SQLConnection();


    public String next() {
      return getMessage(false, ++indexMessage);
    }

    public String previous() {
      return getMessage(false, --indexMessage);
    }

    public String findMessage(String message) {
        String tmp = "";
        ArrayList<String> result;
        result = sqlConnection.executeQuery("SELECT authorsMessages.message, authors.name FROM authorsMessages INNER JOIN authors ON authors.id=authorsMessages.authorID WHERE authors.name LIKE '%" + message + "%' OR authorsMessages.message LIKE '%" + message + "%'");
        for (int i = 0; i < result.size(); i++) {
            tmp+=result.get(i);
        }
        return tmp;
    }

    public String saveMessage(String command) {
        String[] tmp = command.replaceAll("/add -author=", "=").replaceAll("-message=", "=").split("=");
        String author = tmp[1];
        String message = tmp[2];
        int authorID = 0;
        ArrayList<String> arrayList;
        arrayList = sqlConnection.executeQuery("SELECT authors.id FROM authors WHERE authors.name LIKE '" + author + "'");
        authorID = arrayList.size()!=0?Integer.parseInt(arrayList.get(0)):-1;
        if (authorID == -1) {
            authorID = getSizeAuthors() + 1;
            sqlConnection.execute("INSERT INTO authors(id,name) values (" + authorID + ",'" + author + "\n')");
        }
        sqlConnection.execute("INSERT INTO authorsMessages(id,authorID,message) values (" + (getSize() + 1) + "," + authorID + ",'" + message + "\n')");
        return author;
    }

    public String getMessage(boolean random, int indexMessage) {
        return random ? getRandomMessage() : getIndexMessage(indexMessage);
    }

    private String getRandomMessage() {
        ArrayList<String> listMessage=sqlConnection.executeQuery("SELECT authorsMessages.message, authors.name, authorsMessages.id FROM authors, authorsMessages WHERE authors.id LIKE authorsMessages.authorID ORDER BY RAND() LIMIT 1");
        indexMessage=Integer.parseInt(listMessage.get(2));
        return listMessage.size()!=0?listMessage.get(0)+listMessage.get(1):"Нет данных!";
    }

    private String getIndexMessage(int indexMessage) {
        this.indexMessage = indexMessage;
        ArrayList<String> listMessage=sqlConnection.executeQuery("SELECT authorsMessages.message, authors.name FROM authors, authorsMessages WHERE authorsMessages.id LIKE '" + this.indexMessage + "' AND authors.id LIKE authorsMessages.authorID");
        return listMessage.size()!=0?listMessage.get(0)+listMessage.get(1):"Нет данных!";
    }

    private int getSize() {
        return Integer.parseInt(sqlConnection.executeQuery("SELECT count(*) FROM authorsMessages").get(0));
    }

    private int getSizeAuthors() {
        return Integer.parseInt(sqlConnection.executeQuery("SELECT count(*) FROM authors").get(0));
    }
}
