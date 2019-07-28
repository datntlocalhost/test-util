package jp.datnt.oxy.configuration;

/**
 * The Class MemoryConfigurationOptions.
 */
public class MemoryConfigurationOptions extends ConfigurationOptions {

    /**
     * Instantiates a new memory configuration options.
     *
     * @param configuration the configuration
     */
    protected MemoryConfigurationOptions(MemoryConfiguration configuration) {
        super(configuration);
    }

    /**
     * Configuration.
     *
     * @return the memory configuration
     */
    @Override
    public MemoryConfiguration configuration() {
        return (MemoryConfiguration) super.configuration();
    }

    /**
     * Copy defaults.
     *
     * @param value the value
     * @return the memory configuration options
     */
    @Override
    public MemoryConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    /**
     * Path separator.
     *
     * @param value the value
     * @return the memory configuration options
     */
    @Override
    public MemoryConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }
}
