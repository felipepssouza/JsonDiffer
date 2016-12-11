package br.com.felipe.json.persistence;

import br.com.felipe.adapter.mysql.JsonDiffRepositoryAdapter;
import br.com.felipe.vo.JsonStructureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class responsible of retrieve of JSON
 */
@Component
public class RetrieveJsonImplementation implements RetrieveJson {

    @Autowired
    private JsonDiffRepositoryAdapter repositoryAdapter;

    @Override
    public List<JsonStructureVO> retrieveJsonById(String id) {
        return repositoryAdapter.getById(id);
    }
}
