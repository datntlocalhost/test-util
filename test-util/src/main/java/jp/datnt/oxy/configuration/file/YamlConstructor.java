package jp.datnt.oxy.configuration.file;

import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

import jp.datnt.oxy.configuration.serialization.ConfigurationSerialization;

/**
 * The Class YamlConstructor.
 */
public class YamlConstructor extends SafeConstructor {
    
    /**
     * Instantiates a new yaml constructor.
     */
    public YamlConstructor() {
        this.yamlConstructors.put(Tag.MAP, new ConstructCustomObject());
    }

    /**
     * The Class ConstructCustomObject.
     */
    private class ConstructCustomObject extends ConstructYamlMap {
        
        /**
         * Construct.
         *
         * @param node the node
         * @return the object
         */
        @Override
        public Object construct(Node node) {
            if (node.isTwoStepsConstruction()) {
                throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
            }

            Map<?, ?> raw = (Map<?, ?>) super.construct(node);

            if (raw.containsKey(ConfigurationSerialization.SERIALIZED_TYPE_KEY)) {
                Map<String, Object> typed = new LinkedHashMap<String, Object>(raw.size());
                for (Map.Entry<?, ?> entry : raw.entrySet()) {
                    typed.put(entry.getKey().toString(), entry.getValue());
                }

                try {
                    return ConfigurationSerialization.deserializeObject(typed);
                } catch (IllegalArgumentException ex) {
                    throw new YAMLException("Could not deserialize object", ex);
                }
            }

            return raw;
        }

        /**
         * Construct 2 nd step.
         *
         * @param node the node
         * @param object the object
         */
        @Override
        public void construct2ndStep(Node node, Object object) {
            throw new YAMLException("Unexpected referential mapping structure. Node: " + node);
        }
    }
}
