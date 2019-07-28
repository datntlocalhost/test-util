package jp.datnt.oxy.information;

import java.util.List;

import org.apache.commons.lang3.Validate;

import jp.datnt.oxy.configuration.file.FileConfiguration;
import jp.datnt.oxy.configuration.file.YamlConfiguration;

/**
 * The Class CopyFileInformation.
 * 
 * @author DatNT
 */
public class CopyFileInformation extends Information {

    /** The from folder. */
    private String fromFolder;

    /** The to folder. */
    private String toFolder;

    /** The files. */
    private List<String> files;

    /** The keep path. */
    private boolean keepPath;

    /**
     * Instantiates a new copy file information.
     */
    public CopyFileInformation() {
    }

    /**
     * Instantiates a new copy file information.
     *
     * @param fromFolder the from folder
     * @param toFolder the to folder
     * @param files the files
     * @param keepPath the keep path
     */
    public CopyFileInformation(String fromFolder, String toFolder, List<String> files, boolean keepPath) {
        this.fromFolder = fromFolder;
        this.toFolder = toFolder;
        this.files = files;
        this.keepPath = keepPath;
    }

    /**
     * Instantiates a new copy file information.
     *
     * @param configuration the configuration
     */
    public CopyFileInformation(FileConfiguration configuration) {
        Validate.notNull(configuration, "File configuration cannot be null");
        this.fromFolder = configuration.getString("copy-file.from.path", "");
        this.toFolder = configuration.getString("copy-file.to.path", "");
        this.files = configuration.getStringList("copy-file.from.files");
        this.keepPath = configuration.getBoolean("copy-file.keep-path", false);
    }

    /**
     * Sets the configuration.
     *
     * @return the file configuration
     */
    @Override
    protected FileConfiguration setConfiguration() {
        FileConfiguration configuration = new YamlConfiguration();
        configuration.set("copy-file.keep-path", false);
        configuration.set("copy-file.from.path", "");
        configuration.set("copy-file.to.path", "");
        configuration.set("copy-file.from.files", "");
        return configuration;
    }

    /**
     * Gets the from folder.
     *
     * @return the from folder
     */
    public String getFromFolder() {
        return fromFolder;
    }

    /**
     * Sets the from folder.
     *
     * @param fromFolder the new from folder
     */
    public void setFromFolder(String fromFolder) {
        this.fromFolder = fromFolder;
    }

    /**
     * Gets the to folder.
     *
     * @return the to folder
     */
    public String getToFolder() {
        return toFolder;
    }

    /**
     * Sets the to folder.
     *
     * @param toFolder the new to folder
     */
    public void setToFolder(String toFolder) {
        this.toFolder = toFolder;
    }

    /**
     * Gets the files.
     *
     * @return the files
     */
    public List<String> getFiles() {
        return files;
    }

    /**
     * Sets the files.
     *
     * @param files the new files
     */
    public void setFiles(List<String> files) {
        this.files = files;
    }

    /**
     * Checks if is keep path.
     *
     * @return true, if is keep path
     */
    public boolean isKeepPath() {
        return keepPath;
    }

    /**
     * Sets the keep path.
     *
     * @param keepPath the new keep path
     */
    public void setKeepPath(boolean keepPath) {
        this.keepPath = keepPath;
    }

}
