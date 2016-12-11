package br.com.felipe.dao;

import br.com.felipe.model.JsonStructure;
import org.springframework.data.repository.CrudRepository;

public interface JsonDiffCrud extends CrudRepository<JsonStructure, String> {

    JsonStructure save(JsonStructure json);

}
