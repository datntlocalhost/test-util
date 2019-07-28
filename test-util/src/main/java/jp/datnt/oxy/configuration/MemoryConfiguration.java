package jp.datnt.oxy.configuration;

import java.util.Map;

import org.apache.commons.lang3.Validate;

/**
 * The Class MemoryConfiguration.
 */
public class MemoryConfiguration extends MemorySection implements Configuration {

    /** The defaults. */
    protected Configuration defaults;

    /** The options. */
    protected MemoryConfigurationOptions options;

    /**
     * Creates an empty {@link MemoryConfiguration} with no default values.
     */
    public MemoryConfiguration() {
    }

    /**
     * Creates an empty {@link MemoryConfiguration} using the specified {@link Configuration} as a source for all
     * default values.
     *
     * @param defaults Default value provider
     * @throws IllegalArgumentException Thrown if defaults is null
     */
    public MemoryConfiguration(Configuration defaults) {
        this.defaults = defaults;
    }

    /**
     * Adds the default.
     *
     * @param path the path
     * @param value the value
     */
    @Override
    public void addDefault(String path, Object value) {
        Validate.notNull(path, "Path may not be null");

        if (defaults == null) {
            defaults = new MemoryConfiguration();
        }

        defaults.set(path, value);
    }

    /**
     * Adds the defaults.
     *
     * @param defaults the defaults
     */
    public void addDefaults(Map<String, Object> defaults) {
        Validate.notNull(defaults, "Defaults may not be null");

        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            addDefault(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Adds the defaults.
     *
     * @param defaults the defaults
     */
    public void addDefaults(Configuration defaults) {
        Validate.notNull(defaults, "Defaults may not be null");

        addDefaults(defaults.getValues(true));
    }

    /**
     * Sets the defaults.
     *
     * @param defaults the new defaults
     */
    public void setDefaults(Configuration defaults) {
        Validate.notNull(defaults, "Defaults may not be null");

        this.defaults = defaults;
    }

    /**
     * Gets the defaults.
     *
     * @return the defaults
     */
    public Configuration getDefaults() {
        return defaults;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    @Override
    public ConfigurationSection getParent() {
        return null;
    }

    /**
     * Options.
     *
     * @return the memory configuration options
     */
    public MemoryConfigurationOptions options() {
        if (options == null) {
            options = new MemoryConfigurationOptions(this);
        }

        return options;
    }
}
