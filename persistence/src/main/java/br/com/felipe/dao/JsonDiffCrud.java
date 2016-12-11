package br.com.felipe.dao;

import br.com.felipe.model.JsonStructure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JsonDiffCrud extends CrudRepository<JsonStructure, String> {

    JsonStructure save(JsonStructure json);

    @Query("select o from JsonStructure o where id = :id")
    List<JsonStructure> findById(@Param("id") String id);

}
