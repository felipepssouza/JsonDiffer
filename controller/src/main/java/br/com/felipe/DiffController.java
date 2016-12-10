package br.com.felipe;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Felipe on 10/12/2016.
 */
@RestController
public class DiffController {

    @RequestMapping(value = "/diff/{id}/left", method = RequestMethod.POST)
    public String left(@PathVariable String id) {
        return id;
    }
}
