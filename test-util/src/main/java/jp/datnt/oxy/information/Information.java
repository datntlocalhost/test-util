package jp.datnt.oxy.information;

import java.io.IOException;

import jp.datnt.oxy.configuration.file.FileConfiguration;

public abstract class Information {

    public void createFileConfig(String file) throws IOException {
        FileConfiguration configuration = this.setConfiguration();
        configuration.save(file);
    }

    protected abstract FileConfiguration setConfiguration();
}
