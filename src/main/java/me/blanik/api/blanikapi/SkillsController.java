package me.blanik.api.blanikapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class SkillsController {

    public static ArrayList<Map> getSkillsList() {
        ArrayList<Map> skillsList = new ArrayList();
        skillsList.add(Map.of("title", "TypeScript / JavaScripts", "description", "I have been using JavaScripts ES6+ on my daily. Mostly I prefer to use TypeScript in the latest possible version on my projects.", "icon", "JS"));
        skillsList.add(Map.of("title", "React / NextJS", "description", "I have experience in building commercial React application and UI libraries for React application. For React I've preferred to use Next.JS framework for building server-side rendered application and rollup with a storybook for building UI libraries.", "icon", "React"));
        skillsList.add(Map.of("title", "Angular 2+", "description", "I have experience in building commercial Angular 8, 9, 10 and 11 application with RxJS", "icon", "Angular"));
        skillsList.add(Map.of("title", "Google Analytics", "description", "I have been certified with Google Analytics Individual Qualification.", "icon", "Google"));
        skillsList.add(Map.of("title", "Accessibility (WCAG 2.1)", "description", "I have experience in building applications that support WCAG 2.1 accessibility guidelines.", "icon", "Accessibility"));
        skillsList.add(Map.of("title", "HTML5 / CSS3", "description", "I had developed my first website in HTML5 and CSS3 a little bit after it was released in 2009 when I was 13 years old.", "icon", "HTML"));
        skillsList.add(Map.of("title", "SCRUM / AGILE", "description", "I have experienced working and organising scrum sprints.", "icon", "Send"));
        skillsList.add(Map.of("title", "GIT", "description", "I have experienced working and organising git repositories (GitHub, GitHub Enterprise, GitLab).", "icon", "Git"));
        skillsList.add(Map.of("title", "Docker", "description", "I have experienced working in docker containers", "icon", "Docker"));
        skillsList.add(Map.of("title", "…a one more thing", "description", "I have a little experience in backend technologies such as Node.JS, PHP, Python and Java.", "icon", "Node.JS"));

        return skillsList;
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET, produces = "application/json")
    public Map index() {
        return Map.ofEntries(
                Map.entry("title","Skills"),
                Map.entry("text", "## Selected skills\n" +
                        "\n" +
                        "I am a Frontend Developer with highly skilled React and Angular, but my competitions go far beyond that.\n" +
                        "\n" +
                        "Here is the selected modern and demanded skills that I use in my daily work."),
                Map.entry("elements", this.getSkillsList())
        );
    }
}
