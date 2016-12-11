package br.com.felipe.model;

import br.com.felipe.vo.JsonPosition;

import java.io.Serializable;

public class JsonId implements Serializable {

    protected String id;
    protected JsonPosition position;

    public JsonId() {
        super();
    }

    public JsonId(String id, JsonPosition position) {
        this.id = id;
        this.position = position;
    }
}
