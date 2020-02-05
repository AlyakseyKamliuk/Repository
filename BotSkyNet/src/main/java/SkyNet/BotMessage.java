package SkyNet;
import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class BotMessage implements Closeable {

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
        indexMessage = hasPrevious() ? indexMessage - 1 : getSize()-1;
        return getMessage(false, indexMessage);
    }

    private void randomIndex() {
        indexMessage = getSize() == 1 ? 0 : new Random().nextInt(getSize());
    }

    public String getMessage(boolean random, int indexMessage) {
        if (random) {
            randomIndex();
        } else {
            this.indexMessage = indexMessage;
        }
        String message = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet1 = statement.executeQuery("SELECT message, author FROM authorsMessages WHERE id LIKE '" + this.indexMessage + "'")) {
            while (resultSet1.next()) {
                message = resultSet1.getString(1) + resultSet1.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
