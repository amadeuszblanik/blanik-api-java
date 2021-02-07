package me.blanik.api.blanikapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class ExperienceController {

    private long calculateDateDiff(Date startDate, Date endDate) {
        long diffInMs = Math.abs(endDate.getTime() - startDate.getTime());
        long daysDiff = TimeUnit.DAYS.convert(diffInMs, TimeUnit.MILLISECONDS);

        return daysDiff;
    }

    private String formatDateDiff(long daysDiff) {
        long yearsDiff = Math.round(daysDiff / 365);
        long monthsDiff = (daysDiff - yearsDiff * 365) / 30 + 1;

        String yearsFormatted = yearsDiff > 1 ? yearsDiff + " years" : yearsDiff + " year";
        String monthsFormatted = monthsDiff > 1 ? monthsDiff + " months" : yearsDiff + " month";

        return yearsDiff > 0 ? yearsFormatted + " " + monthsFormatted : monthsFormatted;
    }

    private Map getHistorySingle(String companyName, String position, String[] description, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("MM/yyyy", Locale.ENGLISH);

        return Map.ofEntries(
                Map.entry("name", companyName),
                Map.entry("position", position),
                Map.entry("description", description),
                Map.entry("startDate", dateFormat.format(startDate)),
                Map.entry("startDateRaw", startDate),
                Map.entry("endDate",  calculateDateDiff(endDate, new Date()) <= 1 ? "Now" : dateFormat.format(endDate)),
                Map.entry("endDateRaw", endDate),
                Map.entry("duration", formatDateDiff(calculateDateDiff(startDate, endDate))),
                Map.entry("durationShort", formatDateDiff(calculateDateDiff(startDate, endDate)))
        );
    }

    @RequestMapping(value = "/experience", method = RequestMethod.GET, produces = "application/json")
    public Map index() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Map[] historyData = new Map[]{
                getHistorySingle(
                        "Efigence",
                        "Lead Frontend Developer",
                        new String[]{
                                "Developing and leading development responsive web applications and websites frontends in the latest technologies (TypeScript, JavaScript ES6+, SASS, React, Styled-components, Angular, Node.JS).",
                                "Optimising websites and web applications for Google Analytics and SEO (Proved with Google Analytics Individual Qualification).",
                                "Creating custom components for mobile hybrid applications.",
                                "Working closely with UX and Web designers.",
                                "Working with an agile team to develop UX components in React.JS.",
                                "Managing with custom Node.JS servers.",

                        },
                        dateFormat.parse("2019-06-02"),
                        new Date()),
                getHistorySingle(
                        "NoMonday",
                        "Frontend Developer",
                        new String[]{
                                "Developing templates for custom-made CMS system.",
                                "Creating fully responsive websites in HTML5, Handlebars, SASS and JavaScripts that works in every modern browser and operating system.",
                                "Developing and maintenance websites based on Wordpress.",
                                "Improving webpage speed and basic SEO optimisations. Gaining more than 90 out of 100 points in Google PageSpeed.",
                                "Preparing website for supports accessibility and screen readers WCAG 2.1."
                        },
                        dateFormat.parse("2018-03-02"),
                        dateFormat.parse("2019-06-02")),
                getHistorySingle(
                        "13design",
                        "Frontend Developer",
                        new String[]{
                                "Developing frontends in HTML5, CSS3, Less.",
                                "Developing and maintenance Wordpress websites."
                        },
                        dateFormat.parse("2017-01-02"),
                        dateFormat.parse("2017-04-02"))
        };

        return Map.ofEntries(
                Map.entry("seniority", "**Senior** / Lead"),
                Map.entry("history", historyData)
        );
    }
}
