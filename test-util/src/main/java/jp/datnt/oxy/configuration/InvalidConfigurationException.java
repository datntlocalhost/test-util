package jp.datnt.oxy.configuration;

/**
 * The Class InvalidConfigurationException.
 * 
 * @author DatNT
 */
public class InvalidConfigurationException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4374888250341537975L;

    /**
     * Instantiates a new invalid configuration exception.
     */
    public InvalidConfigurationException() {
    }

    /**
     * Instantiates a new invalid configuration exception.
     *
     * @param msg the msg
     */
    public InvalidConfigurationException(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new invalid configuration exception.
     *
     * @param cause the cause
     */
    public InvalidConfigurationException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new invalid configuration exception.
     *
     * @param msg the msg
     * @param cause the cause
     */
    public InvalidConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
