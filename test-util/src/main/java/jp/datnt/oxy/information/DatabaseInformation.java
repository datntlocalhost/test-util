package jp.datnt.oxy.information;

import org.apache.commons.lang3.Validate;

import jp.datnt.oxy.configuration.file.FileConfiguration;
import jp.datnt.oxy.configuration.file.YamlConfiguration;
import jp.datnt.oxy.util.StringUtil;

/**
 * The Class DatabaseInformation.
 * 
 * @author DatNT
 */
public class DatabaseInformation extends Information {

    /** The host. */
    private String host;

    /** The port. */
    private String port;

    /** The schema. */
    private String schema;

    /** The type. */
    private DatabaseType type;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /**
     * Instantiates a new database information.
     *
     * @param type the type
     * @param host the host
     * @param port the port
     * @param schema the schema
     * @param username the username
     * @param password the password
     */
    public DatabaseInformation(String type, String host, String port, String schema, String username, String password) {
        this.type = DatabaseType.getType(type);
        this.host = host;
        this.port = port;
        this.schema = schema;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new database information.
     *
     * @param fileConfig the file config
     */
    public DatabaseInformation(FileConfiguration fileConfig) {
        Validate.notNull(fileConfig, "File config cannot be null");
        this.type = DatabaseType.getType(fileConfig.getString("database.type", ""));
        this.host = fileConfig.getString("database.host", "");
        this.port = fileConfig.getString("database.port", "");
        this.schema = fileConfig.getString("database.schema", "");
        this.username = fileConfig.getString("database.username", "");
        this.password = fileConfig.getString("database.password", "");
    }

    /**
     * Sets the configuration.
     *
     * @return the file configuration
     */
    @Override
    protected FileConfiguration setConfiguration() {
        FileConfiguration configuration = new YamlConfiguration();
        configuration.set("database.type", "");
        configuration.set("database.host", "");
        configuration.set("database.port", "");
        configuration.set("database.schema", "");
        configuration.set("database.username", "");
        configuration.set("database.password", "");
        return configuration;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return type.getUrl(host, port, schema);
    }

    /**
     * Gets the driver.
     *
     * @return the driver
     */
    public String getDriver() {
        return type.getDriver();
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     *
     * @param host the new host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Gets the port.
     *
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the port.
     *
     * @param port the new port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Gets the schema.
     *
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets the schema.
     *
     * @param schema the new schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public DatabaseType getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(DatabaseType type) {
        this.type = type;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "DatabaseInformation [host=" + host + ", port=" + port + ", schema=" + schema + ", type=" + type
            + ", username=" + username + ", password=" + password + "]";
    }

    /**
     * The Enum DatabaseType.
     */
    public enum DatabaseType {

        /** The mysql. */
        MYSQL("com.mysql.cj.jdbc.Driver",
            "jdbc:mysql://{0}:{1}/{2}?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"),

        /** The oracle. */
        ORACLE("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@{0}:{1}:{2}"),

        /** The undefine. */
        UNDEFINE("", "")

        ;

        /** The driver. */
        private String driver;

        /** The url. */
        private String url;

        /**
         * Instantiates a new database type.
         *
         * @param driver the driver
         * @param url the url
         */
        private DatabaseType(String driver, String url) {
            this.driver = driver;
            this.url = url;
        }

        /**
         * Gets the type.
         *
         * @param type the type
         * @return the type
         */
        public static DatabaseType getType(String type) {
            if (StringUtil.isNullOrEmpty(type)) {
                return UNDEFINE;
            } else if (type.equalsIgnoreCase("mysql")) {
                return MYSQL;
            } else if (type.equalsIgnoreCase("oracle")) {
                return ORACLE;
            } else {
                return UNDEFINE;
            }
        }

        /**
         * Gets the driver.
         *
         * @return the driver
         */
        public String getDriver() {
            return driver;
        }

        /**
         * Gets the url.
         *
         * @param host the host
         * @param port the port
         * @param schema the schema
         * @return the url
         */
        public String getUrl(String host, String port, String schema) {
            return url.replace("{0}", host).replace("{1}", port).replace("{2}", schema);
        }
    }

}
