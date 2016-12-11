package br.com.felipe.vo;

import java.util.ArrayList;

/**
 * NullObject for insight
 */
public class NullInsight extends Insight {

    public NullInsight() {
        super();
        super.differenceValueOffset = new ArrayList<>();
        super.differentKeys = new ArrayList<>();
    }
}
