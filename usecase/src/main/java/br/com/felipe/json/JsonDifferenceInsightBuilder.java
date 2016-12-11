package br.com.felipe.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

/**
 * Class responsible to build a JSON with the insight difference of two Map
 */
public class JsonDifferenceInsightBuilder {

    private static final String DIFFERENCE_KEYS = "differentKeys";
    private static final String KEY = "key";
    private static final String OFFSET = "offset";
    private static final String SIZE = "size";
    private static final String DIFFERENCE_OFFSET_VALUE = "differenceValueOffset";

    /**
     * Method responsible to check differences from Map e report into a JSON called insight
     * @param left
     * @param right
     * @return String
     */
    public String buildJson(Map<String, String> left, Map<String, String> right) {
        JsonObject json = new JsonObject();
        JsonObject insight = new JsonObject();
        JsonArray differentKeys = new JsonArray();
        JsonArray differenceValueOffset = new JsonArray();
        for (Map.Entry<String, String> leftKeyValue : left.entrySet()){
            if(!right.containsKey(leftKeyValue.getKey())) {
                JsonObject difference = new JsonObject();
                difference.addProperty(leftKeyValue.getKey(), leftKeyValue.getValue());
                differentKeys.add(difference);
                continue;
            }
            Pair<Integer, Integer> tuple = this.difference(leftKeyValue.getValue(), right.get(leftKeyValue.getKey()));
            JsonObject difference = new JsonObject();
            difference.addProperty(KEY, leftKeyValue.getKey());
            difference.addProperty(OFFSET, tuple.getLeft());
            difference.addProperty(SIZE, tuple.getRight());
            differenceValueOffset.add(difference);
        }
        insight.add(DIFFERENCE_KEYS, differentKeys);
        insight.add(DIFFERENCE_OFFSET_VALUE, differenceValueOffset);
        json.add("insight", insight);
        return json.toString();
    }

    /**
     * Method responsible to return a tuple of the first ocurrence of
     *  difference and size of difference of elements
     * @param right
     * @param left
     * @return Tuple(Pair)
     */
    private Pair<Integer, Integer> difference(String right, String left){
        int offset  = StringUtils.indexOfDifference(left,right);
        if(offset == 0){
            return Pair.of(0, 0);
        }
        int sizeOfDifference = right.length() - offset;
        return Pair.of(offset, sizeOfDifference);
    }

}
