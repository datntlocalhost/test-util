package jp.datnt.oxy.database;

import java.sql.Connection;

import org.apache.commons.lang3.Validate;

import jp.datnt.oxy.information.DatabaseInformation;

public class DBManager {

    private static Connection connection = null;

    public static void init(DatabaseInformation databaseInfo) {
        connection = DBFactory.getConnection(databaseInfo);
    }

    public static Connection getConnection() {
        Validate.notNull(connection, "DBMananger should be init before get connection.");
        return connection;
    }

    public static void safeCloseConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
