package br.com.felipe.model;

import br.com.felipe.vo.JsonPosition;
import br.com.felipe.vo.JsonStructureVO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Model responsible to storage encoded JSON (Base64)
 */
@Entity
@IdClass(JsonId.class)
public class JsonStructure implements Serializable {

    @Id
    private String id;

    private String encodedJson;

    @Id
    private JsonPosition position;

    public JsonStructure() {
        super();
    }

    public JsonStructure(String id, String encodedJson, JsonPosition position) {
        this.id = id;
        this.encodedJson = encodedJson;
        this.position = position;
    }

    public static JsonStructure fromVO(JsonStructureVO vo){
        return new JsonStructure(vo.getId(), vo.getEncodedJson(), vo.getPosition());
    }

    @Enumerated(EnumType.STRING)
    public JsonPosition getPosition() {
        return position;
    }
}
