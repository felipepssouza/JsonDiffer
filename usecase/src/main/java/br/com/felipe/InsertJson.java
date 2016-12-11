package br.com.felipe;

/**
 * Interface responsible to insert the json
 */
public interface InsertJson {

    void insertLeftJson(String id, String encodedJson);

    void insertRightJson(String id, String encodedJson);

}
