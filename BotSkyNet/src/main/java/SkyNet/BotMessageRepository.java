package SkyNet;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class BotMessageRepository implements Closeable {

    private Connection connection = createConnection();
    private int indexMessage = 0;

    private int getSize() {
        int size = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM authorsMessages")) {
            while (resultSet.next()) {
                size = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    private int getSizeAuthors() {
        int size = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM authors")) {
            while (resultSet.next()) {
                size = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    public static void main(String[] args) {
        BotMessageRepository botMessageRepository=new BotMessageRepository();
        botMessageRepository.addAuthorMessageToBase("/add -author=И Сталин -message=Нужно быть очень смелым человеком, чтобы быть трусом в Советской Армии.");
        System.out.println(botMessageRepository.thisIsAuthorOrMessage("Сталин"));
    }

    private boolean hasNext() {
        return indexMessage != getSize();
    }

    private boolean hasPrevious() {
        return indexMessage > 2;
    }

    public String next() {
        indexMessage = hasNext() ? ++indexMessage : 0;
        return getMessage(false, indexMessage);
    }

    public String previous() {
        indexMessage = hasPrevious() ? --indexMessage : getSize() - 1;
        return getMessage(false, indexMessage);
    }

    public String thisIsAuthorOrMessage(String message) {
        String tmp = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet1 = statement.executeQuery("SELECT authorsMessages.message, authors.name FROM authorsMessages INNER JOIN authors ON authors.id=authorsMessages.authorID WHERE authors.name LIKE '%"+message+"%' OR authorsMessages.message LIKE '%"+message+"%'")) {
            while (resultSet1.next()) {
                tmp += resultSet1.getString(1) + resultSet1.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public String addAuthorMessageToBase(String command) {
        String[] tmp = command.replaceAll("/add -author=", "=").replaceAll("-message=", "=").split("=");
        String author = tmp[1];
        String message = tmp[2];
        int authorID=-1;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet=statement.executeQuery("SELECT authors.id FROM authors WHERE authors.name LIKE '"+author+"'");
            while (resultSet.next()) {
                authorID = resultSet.getInt(1) ;
            }
            if (authorID==-1)  {authorID=getSizeAuthors() + 1;
                statement.execute("INSERT INTO authors(id,name) values (" + authorID + ",'" + author + "\n')");
            }
            statement.execute("INSERT INTO authorsMessages(id,authorID,message) values (" + (getSize() + 1) + "," + authorID + ",'" + message + "\n')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public String getMessage(boolean random, int indexMessage) {
        String message = "";
        if (random) {
            ResultSet resultSet1 = null;
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT authorsMessages.message, authors.name, authorsMessages.id FROM authors, authorsMessages WHERE authors.id LIKE authorsMessages.authorID ORDER BY RAND() LIMIT 1")) {
                while (resultSet.next()) {
                    message = resultSet.getString(1) + resultSet.getString(2);
                    this.indexMessage = resultSet.getInt(3);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            this.indexMessage = indexMessage;

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet1 = statement.executeQuery("SELECT authorsMessages.message, authors.name FROM authors, authorsMessages WHERE authorsMessages.id LIKE '" + this.indexMessage + "' AND authors.id LIKE authorsMessages.authorID")) {
                while (resultSet1.next()) {
                    message = resultSet1.getString(1) + resultSet1.getString(2);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    private Connection createConnection() {
        String dataBasePath = ClassLoader.getSystemClassLoader().getResource("test.mv.db").getFile();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:" + dataBasePath, "sa", "");
            return connection;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
