package br.com.felipe.mysql;

import br.com.felipe.adapter.mysql.JsonDiffRepositoryAdapter;
import br.com.felipe.dao.JsonDiffCrud;
import br.com.felipe.model.JsonStructure;
import br.com.felipe.vo.JsonStructureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonDiffRepository implements JsonDiffRepositoryAdapter {

    @Autowired
    private JsonDiffCrud jsonDiffCrud;

    @Override
    public void insert(JsonStructureVO vo) {
        jsonDiffCrud.save(JsonStructure.fromVO(vo));
    }

    @Override
    public List<JsonStructureVO> getById(String id) {
        List<JsonStructure> jsonsById = jsonDiffCrud.findById(id);
        List<JsonStructureVO> jsonVOs = jsonsById.stream()
                .map( it -> it.toVO() ).collect(Collectors.toList());
        return jsonVOs;
    }
}
