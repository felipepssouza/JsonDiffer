package br.com.felipe.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * VO representing insight of differences in JSON
 */
public class Insight {

    protected List<String> differentKeys;
    protected List<JsonObjectDifference> differenceValueOffset;

    public Insight() {
        super();
    }

    public void addDifferentKey(String differentKey) {
        if(this.differentKeys == null){
            this.differentKeys = new ArrayList<>();
        }
        this.differentKeys.add(differentKey);
    }

    public void addDifferenceValueOffset(JsonObjectDifference differenceValueOffset) {
        if(this.differenceValueOffset == null){
            this.differenceValueOffset = new ArrayList<>();
        }
        this.differenceValueOffset.add(differenceValueOffset);
    }

    public List<String> getDifferentKeys() {
        return differentKeys;
    }

    public List<JsonObjectDifference> getDifferenceValueOffset() {
        return differenceValueOffset;
    }
}
