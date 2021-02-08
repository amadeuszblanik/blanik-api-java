package me.blanik.api.blanikapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.json.JSONObject;

public class WorksService {
    private String baseUrl = "https://cdn.contentful.com";
    String spaceId = System.getenv("CONTENTFUL_SPACE_ID");
    String environmentId = System.getenv("CONTENTFUL_ENVIRONMENT_ID");
    String accessToken = System.getenv("CONTENTFUL_ACCESS_TOKEN");

    private URI getApiUrl (String fetchUrl) {
        URI uri = URI.create(baseUrl + "/spaces/" + spaceId + "/" + fetchUrl + "?access_token=" + accessToken);
        return uri;
    }

    public Map<String, Object> getEntries() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(getApiUrl("environments/" + environmentId + "/entries"))
                .header("accept", "application/json")
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObj = new JSONObject(response.body());

        System.out.println(response);

        return jsonObj.toMap();
    }

    public Map<String, Object> getAsset(String assetId) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(getApiUrl("assets/" + assetId))
                .header("accept", "application/json")
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObj = new JSONObject(response.body());

        System.out.println(response);

        return jsonObj.toMap();
    }
}
