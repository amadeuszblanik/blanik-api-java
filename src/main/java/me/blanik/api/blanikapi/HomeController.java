package me.blanik.api.blanikapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public Map index() {
        return Map.ofEntries(
                Map.entry("name","Amadeusz Blanik"),
                Map.entry("position","Senior Frontend Developer"),
                Map.entry("positionShort","Frontend Developer"),
                Map.entry("location","Rybnik, Poland"),
                Map.entry("motto","I am the one who make IT works!"),
                Map.entry("readMore", Map.of("about-me", "/about-me", "skills", "/skills", "experience", "/experience"))
        );
    }
}
