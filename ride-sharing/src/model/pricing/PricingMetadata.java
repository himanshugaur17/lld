package model.pricing;

import java.util.HashMap;
import java.util.Map;

public class PricingMetadata {
    private final Map<String, Object> metadata;

    private PricingMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Object get(String key) {
        return metadata.get(key);
    }

    public static class Builder {
        private final Map<String, Object> metadata;

        public Builder() {
            this.metadata = new HashMap<>();
        }

        public Builder add(String key, Object value) {
            metadata.put(key, value);
            return this;
        }

        public PricingMetadata build() {
            return new PricingMetadata(metadata);
        }
    }
}
