package br.com.felipe.vo;

public class JsonStructureVO {

    String id;
    String encodedJson;
    JsonPosition position;

    public JsonStructureVO(String id, String encodedJson, JsonPosition position) {
        this.id = id;
        this.encodedJson = encodedJson;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getEncodedJson() {
        return encodedJson;
    }

    public JsonPosition getPosition() {
        return position;
    }
}
