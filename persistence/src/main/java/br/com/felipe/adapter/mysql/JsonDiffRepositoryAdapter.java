package br.com.felipe.adapter.mysql;

import br.com.felipe.vo.JsonStructureVO;

import java.util.List;

public interface JsonDiffRepositoryAdapter {

    void insert(JsonStructureVO vo);

    List<JsonStructureVO> getById(String id);

}
