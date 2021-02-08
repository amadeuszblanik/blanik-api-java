package me.blanik.api.blanikapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class WorksController {

    @RequestMapping(value = "/works", method = RequestMethod.GET, produces = "application/json")
    public Map index() throws IOException, InterruptedException {
        return new WorksService().getEntries();
    }

    @RequestMapping(value = "/works/asset", params = "id", method = RequestMethod.GET, produces = "application/json")
    public Map asset(@RequestParam("id") String id) throws IOException, InterruptedException {
        return new WorksService().getAsset(id);
    }
}
