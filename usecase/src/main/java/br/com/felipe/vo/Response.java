package br.com.felipe.vo;

/**
 * VO responsible of controller response
 */
public class Response {

    Boolean equal;
    Boolean differentSize;
    Insight insight;

    public Response(Boolean equal, Boolean differentSize, Insight insight) {
        this.equal = equal;
        this.differentSize = differentSize;
        this.insight = insight;
    }
}
