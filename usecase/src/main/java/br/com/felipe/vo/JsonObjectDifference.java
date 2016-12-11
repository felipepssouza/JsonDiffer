package br.com.felipe.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * VO representing the key different, offset and the size
 */
public class JsonObjectDifference {

    String key;
    Integer offset;
    Integer size;

    public JsonObjectDifference(String key, Integer offset, Integer size) {
        this.key = key;
        this.offset = offset;
        this.size = size;
    }

    @Override
    public boolean equals(Object jsonObjectDifferenceToCompare) {
        if (jsonObjectDifferenceToCompare == this) return true;
        if (!(jsonObjectDifferenceToCompare instanceof JsonObjectDifference)) {
            return false;
        }

        JsonObjectDifference jsonObjectDifference = (JsonObjectDifference) jsonObjectDifferenceToCompare;

        return new EqualsBuilder()
                .append(this.key, jsonObjectDifference.key)
                .append(this.offset, jsonObjectDifference.offset)
                .append(this.size, jsonObjectDifference.size)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.key)
                .append(this.offset)
                .append(this.size)
                .toHashCode();
    }

}
