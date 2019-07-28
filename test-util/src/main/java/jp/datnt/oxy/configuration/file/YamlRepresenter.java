package jp.datnt.oxy.configuration.file;

import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.representer.Representer;

import jp.datnt.oxy.configuration.ConfigurationSection;
import jp.datnt.oxy.configuration.serialization.ConfigurationSerializable;
import jp.datnt.oxy.configuration.serialization.ConfigurationSerialization;

/**
 * The Class YamlRepresenter.
 */
public class YamlRepresenter extends Representer {
    
    /**
     * Instantiates a new yaml representer.
     */
    public YamlRepresenter() {
        this.multiRepresenters.put(ConfigurationSection.class, new RepresentConfigurationSection());
        this.multiRepresenters.put(ConfigurationSerializable.class, new RepresentConfigurationSerializable());
    }

    /**
     * The Class RepresentConfigurationSection.
     */
    private class RepresentConfigurationSection extends RepresentMap {
        
        /**
         * Represent data.
         *
         * @param data the data
         * @return the node
         */
        @Override
        public Node representData(Object data) {
            return super.representData(((ConfigurationSection) data).getValues(false));
        }
    }

    /**
     * The Class RepresentConfigurationSerializable.
     */
    private class RepresentConfigurationSerializable extends RepresentMap {
        
        /**
         * Represent data.
         *
         * @param data the data
         * @return the node
         */
        @Override
        public Node representData(Object data) {
            ConfigurationSerializable serializable = (ConfigurationSerializable) data;
            Map<String, Object> values = new LinkedHashMap<String, Object>();
            values.put(ConfigurationSerialization.SERIALIZED_TYPE_KEY, ConfigurationSerialization.getAlias(serializable.getClass()));
            values.putAll(serializable.serialize());

            return super.representData(values);
        }
    }
}
