package jp.datnt.oxy.configuration.serialization;

import java.util.Map;

/**
 * The Interface ConfigurationSerializable.
 */
public interface ConfigurationSerializable {

    /**
     * Creates a Map representation of this class.
     * <p>
     * This class must provide a method to restore this class, as defined in
     * the {@link ConfigurationSerializable} interface javadocs.
     *
     * @return Map containing the current state of this class
     */
    public Map<String, Object> serialize();
}
