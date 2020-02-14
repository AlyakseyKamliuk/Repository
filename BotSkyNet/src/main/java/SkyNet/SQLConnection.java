package SkyNet;
import org.h2.jdbc.JdbcSQLDataException;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class SQLConnection implements Closeable {

    private Connection connection = null;

    public SQLConnection() {
        if (connection==null) this.connection = createConnection();
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

    public void execute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> executeQuery(String sql) {
        int i = 1;
        String tmp="";
        ArrayList<String> arrayList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                while (true) {
                    try {
                        tmp=resultSet.getString(i);
                    } catch (Exception e) {
                       i=1;
                       break;
                    }
                    if (tmp!=null) arrayList.add(tmp);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return arrayList;
        }
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
