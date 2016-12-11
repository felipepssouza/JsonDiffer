package br.com.felipe.json.persistence;

import br.com.felipe.adapter.mysql.JsonDiffRepositoryAdapter;
import br.com.felipe.converter.JsonConverter;
import br.com.felipe.decode.StringDecoder;
import br.com.felipe.insight.DifferenceInsightBuilder;
import br.com.felipe.json.JsonResponse;
import br.com.felipe.map.MapComparator;
import br.com.felipe.vo.Insight;
import br.com.felipe.vo.JsonStructureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class responsible of retrieve of response JSON
 */
@Component
public class RetrieveJsonImplementation implements RetrieveJson {

    @Autowired
    private JsonDiffRepositoryAdapter repositoryAdapter;

    @Autowired
    private StringDecoder decoder;

    @Autowired
    private JsonConverter converter;

    @Autowired
    private MapComparator mapComparator;

    @Autowired
    private JsonResponse jsonResponse;

    @Autowired
    private DifferenceInsightBuilder differenceInsightBuilder;

    @Override
    public String retrieveJsonById(String id) {
        List<JsonStructureVO> jsons = repositoryAdapter.getById(id);
        List<Map<String, String>> jsonMap = jsons.stream()
                .map(json -> converter
                        .toMap(decoder
                                .decodeBase64(json.getEncodedJson()))
                )
                .collect(Collectors.toList());
        Optional<Map<String, String>> leftMap = jsonMap.stream().reduce((first, second) -> first);
        Optional<Map<String, String>> rightMap = jsonMap.stream().reduce((first, second) -> second);
        if(mapComparator.isTotallyEqual(leftMap.get(), rightMap.get())){
            return jsonResponse.buildSuccessJsonResponse();
        }
        if(!mapComparator.isSameSize(leftMap.get(), rightMap.get())){
        }
        Insight insight = differenceInsightBuilder.buildInsight(leftMap.get(), rightMap.get());
        return jsonResponse.buildErrorJsonResponseWithInsight(insight);
    }

}

