package me.blanik.api.blanikapi;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
public class AboutMeController {

    @RequestMapping(value = "/about-me", method = RequestMethod.GET, produces = "application/json")
    public Map index() {
        return Map.ofEntries(
                Map.entry("title","About me"),
                Map.entry("text", "**Hello**\n" +
                        "Nice to see you here! I'm a Frontend Developer based in Rybnik, Poland (REMOTE). I am proud to be a programmer and I take care of every single detail. I can develop fully working front-end layer of websites and web applications. I've been working with varieties of technologies for few years.\n" +
                        "\n" +
                        "Firstly, I am focusing on compatibility with design and motions and then take care of accessibility and semantic. I was inspired to that by projects and companies I worked with and words that dad od Steve Jobs said to him:\n" +
                        "When you're a carpenter making a beautiful chest of drawers, you're not going to use a piece of plywood on the back, even though it faces the wall and nobody will see it. You'll know it's there, so you're going to use a beautiful piece of wood on the back. For you to sleep well at night, the aesthetic, the quality, has to be carried all the way through.\n" +
                        "\n" +
                        "Cheers,\n" +
                        "Amadeusz Blanik")
        );
    }
}
