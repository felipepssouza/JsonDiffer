package br.com.felipe.insight;

import br.com.felipe.vo.Insight;
import br.com.felipe.vo.JsonObjectDifference;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Class responsible to build an object with the insight of differences of two Maps
 */
@Component
public class DifferenceInsightBuilder {

    /**
     * Method responsible to check differences from Map e report into a JSON called insight
     * @param left
     * @param right
     * @return String
     */
    public Insight buildInsight(Map<String, String> left, Map<String, String> right) {
        Insight insight = new Insight();
        for (Map.Entry<String, String> leftKeyValue : left.entrySet()){
            if(!right.containsKey(leftKeyValue.getKey())) {
                insight.addDifferentKey(leftKeyValue.getKey());
                continue;
            }
            Pair<Integer, Integer> tuple = this.difference(leftKeyValue.getValue(), right.get(leftKeyValue.getKey()));
            if(tuple.getLeft() == -1){
                continue;
            }
            insight.addDifferenceValueOffset(new JsonObjectDifference(leftKeyValue.getKey(), tuple.getLeft(), tuple.getRight()));
        }
        return insight;
    }

    /**
     * Method responsible to return a tuple of the first ocurrence of
     *  difference and size of difference of elements
     *
     *  If they are equals return -1
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
