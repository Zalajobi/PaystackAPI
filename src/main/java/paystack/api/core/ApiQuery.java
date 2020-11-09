package paystack.api.core;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import paystack.api.constants.Authorization;

import com.mashape.unirest.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ApiQuery extends Authorization {

    public Map<String, Object> connectAndQuery(HashMap<String, Object> query, String url) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.post(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + getKey())
                    .fields(query)
                    .asJson();

//            System.out.println(queryForResponse.getBody().getObject().toMap());
            return queryForResponse.getBody().getObject().toMap();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Object> getConnectAndQuery(String url) {
        try {
            HttpResponse<JsonNode> queryForResponse = Unirest.get(url)
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + getKey())
                    .asJson();
            return queryForResponse.getBody().getObject().toMap();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }
}
