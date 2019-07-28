package jp.datnt.oxy;

import jp.datnt.oxy.information.DatabaseInformation;

/**
 * The Class ToolConfiguration.
 * 
 * @author DatNT
 */
public class ToolConfiguration {

    /** The database info. */
    public final DatabaseInformation databaseInfo;

    /**
     * Instantiates a new tool configuration.
     *
     * @param databaseInfo the database info
     */
    public ToolConfiguration(DatabaseInformation databaseInfo) {
        this.databaseInfo = databaseInfo;
    }
    
}
