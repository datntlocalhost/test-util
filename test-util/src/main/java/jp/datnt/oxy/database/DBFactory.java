package jp.datnt.oxy.database;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.lang3.Validate;

import jp.datnt.oxy.information.DatabaseInformation;

public final class DBFactory {

    public static Connection getConnection(DatabaseInformation databaseInfo) {
        Validate.notNull(databaseInfo, "Database infomation cannot be null.");

        Connection connection = null;

        try {
            Class.forName(databaseInfo.getDriver());
            connection = DriverManager.getConnection(databaseInfo.getUrl(), databaseInfo.getUsername(),
                databaseInfo.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
