package br.com.felipe.map;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Class responsible to compare equal
 */
@Component
public class MapComparator {

    public boolean isTotallyEqual(Map<String, String> right, Map<String, String> left) {
        return right.equals(left);
    }

    public boolean isSameSize(Map<String, String> right, Map<String, String> left) {
        return right.size() == left.size();
    }

}
