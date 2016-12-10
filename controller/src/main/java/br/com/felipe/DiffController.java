package br.com.felipe;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiffController {

    /**
     * Request responsible to compare two jsons by the id
     * @param id
     * @return
     */
    @RequestMapping(value = "/diff/{id}/", method = RequestMethod.POST)
    public String diff(@PathVariable String id) {
        return id;
    }

    /**
     * Request responsible to storage the left json (JSON is receive in Base64)
     * @param id
     * @param base64JSON
     * @return
     */
    @RequestMapping(value = "/diff/{id}/left", method = RequestMethod.POST)
    public String left(@PathVariable String id, @RequestBody String base64JSON) {
        return id;
    }

    /**
     * Request responsible to storage the right json (JSON is receive in Base64)
     * @param id
     * @param base64JSON
     * @return
     */
    @RequestMapping(value = "/diff/{id}/right", method = RequestMethod.POST)
    public String right(@PathVariable String id, @RequestBody String base64JSON) {
        String json = new String(Base64.decodeBase64(base64JSON));
        return id;
    }

}
