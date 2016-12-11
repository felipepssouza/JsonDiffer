package br.com.felipe;

import br.com.felipe.json.persistence.InsertJson;
import br.com.felipe.json.persistence.RetrieveJson;
import br.com.felipe.vo.JsonStructureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiffController {

    @Autowired
    private InsertJson insertJson;

    @Autowired
    private RetrieveJson retrieveJson;


    /**
     * Request responsible to compare two jsons by the id
     * @param id
     * @return
     */
    @RequestMapping(value = "/diff/{id}/", method = RequestMethod.GET)
    public String diff(@PathVariable String id) {
        return retrieveJson.retrieveJsonById(id);
    }

    /**
     * Request responsible to storage the left json (JSON is receive in Base64)
     * @param id
     * @param base64JSON
     * @return
     */
    @RequestMapping(value = "/diff/{id}/left", method = RequestMethod.POST)
    public String left(@PathVariable String id, @RequestBody String base64JSON) {
        insertJson.insertLeftJson(id, base64JSON);
        return ok();
    }

    /**
     * Request responsible to storage the right json (JSON is receive in Base64)
     * @param id
     * @param base64JSON
     * @return
     */
    @RequestMapping(value = "/diff/{id}/right", method = RequestMethod.POST)
    public String right(@PathVariable String id, @RequestBody String base64JSON) {
        insertJson.insertRightJson(id, base64JSON);
        return ok();
    }

    private String ok(){
        return "Ok!";
    }

}
