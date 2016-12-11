package br.com.felipe.json.persistence;

import br.com.felipe.vo.JsonStructureVO;

import java.util.List;

/**
 * Interface responsible of retrieve of JSON
 */
public interface RetrieveJson {

    List<JsonStructureVO> retrieveJsonById(String id);

}
