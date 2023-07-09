package com.xql.clientmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CreateFetchQuery {
    private String url;
    private String queryStr;
    private int limit;

    public CreateFetchQuery() {
        this.limit = 100;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQueryStr() {
        return this.queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    /**
     * @return int return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String create() {
        String requestBody = "";

        HashMap<String, String> queryMap = new HashMap<String, String>();
        queryMap.put("query", this.queryStr);
        queryMap.put("limit", Integer.toString(limit));

        String jsonStr = "";
        JSONObject queryObj = new JSONObject(queryMap);
        jsonStr = queryObj.toString();
        requestBody = jsonStr;
        try {
            // System.out.println("requestBody: " + requestBody);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .header("Content-Type", "application/json")
                    .build();
            System.out.println("request: " + request.toString());

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            jsonStr = response.body();

            // String uglyJson =
            // "{\"_id\":\"613215d0899cb431ba05722d\",\"index\":0,\"guid\":\"000f4832-57b3-4489-8b69-1b69d3b74af5\",\"isActive\":false,\"balance\":\"$3,266.13\",\"age\":27,\"eyeColor\":\"blue\",\"name\":\"Franks
            // Hoffman\"}";
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode jsonNode = objectMapper.readTree(jsonStr);
            String prettyJson = objectMapper.writeValueAsString(jsonNode);
            System.out.println(prettyJson);

            // System.out.println(jsonStr);
        } catch (InterruptedException ex) {
            System.out.println("ERROR: HTTP InterruptedException " + ex.getMessage());
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("ERROR: HTTP IOException " + ex.getMessage());
            System.exit(0);
        }

        return jsonStr;
    }

}
