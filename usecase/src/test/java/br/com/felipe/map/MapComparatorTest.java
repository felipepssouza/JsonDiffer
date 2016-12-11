package br.com.felipe.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Test for the class comparator of map
 */
public class MapComparatorTest {

    private MapComparator comparator;

    @Before
    public void setup(){
        this.comparator = new MapComparator();
    }

    @Test
    public void shouldReturnFalseIfNotTotallyEquals(){
        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");
        right.put("age","30");

        Map<String, String> left = new HashMap<>();
        left.put("name","Joana");
        left.put("age","20");
        boolean isTotallyEqual = this.comparator.isTotallyEqual(right, left);
        assertThat(isTotallyEqual, equalTo(false));
    }

    @Test
    public void shouldReturnTrueIfTotallyEquals(){
        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");
        right.put("age","30");

        Map<String, String> left = new HashMap<>();
        left.put("name","Felipe");
        left.put("age","30");
        boolean isTotallyEqual = this.comparator.isTotallyEqual(right, left);
        assertThat(isTotallyEqual, equalTo(true));
    }

    @Test
    public void shouldReturnTrueIfTheSameMapSize(){
        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");

        Map<String, String> left = new HashMap<>();
        left.put("name","Felipe");
        boolean isSameSize = this.comparator.isSameSize(right, left);
        assertThat(isSameSize, equalTo(true));
    }

    @Test
    public void shouldReturnFalseIfNotTheSameMapSize(){
        Map<String, String> right = new HashMap<>();
        right.put("name","Felipe");

        Map<String, String> left = new HashMap<>();
        left.put("name","Felipe");
        left.put("Size", "Greater");
        boolean isSameSize = this.comparator.isSameSize(right, left);
        assertThat(isSameSize, equalTo(false));
    }

}
