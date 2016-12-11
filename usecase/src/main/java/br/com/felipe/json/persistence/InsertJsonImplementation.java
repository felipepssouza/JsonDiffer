package br.com.felipe.json.persistence;

import br.com.felipe.adapter.mysql.JsonDiffRepositoryAdapter;
import br.com.felipe.vo.JsonPosition;
import br.com.felipe.vo.JsonStructureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertJsonImplementation implements InsertJson {

    @Autowired
    private JsonDiffRepositoryAdapter repositoryAdapter;

    @Override
    public void insertLeftJson(String id, String encodedJson) {
        repositoryAdapter.insert(new JsonStructureVO(id, encodedJson, JsonPosition.LEFT));
    }

    @Override
    public void insertRightJson(String id, String encodedJson) {
        repositoryAdapter.insert(new JsonStructureVO(id, encodedJson, JsonPosition.RIGHT));
    }
}
