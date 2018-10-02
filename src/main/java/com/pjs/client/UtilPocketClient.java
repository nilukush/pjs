package com.pjs.client;

import com.pjs.client.reqresp.SavedUrlsRequest;
import com.pjs.core.GsonSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;

public class UtilPocketClient {
    private static final Logger LOGGER = LogManager.getLogger(UtilPocketClient.class);
    private static String baseEndpoint = "https://getpocket.com/";
    private static String pocketApiVersion = "v3";

    public static URI getUri(String pocketApiName) throws URISyntaxException {
        URI uri = null;
        try {
            uri = new URI(baseEndpoint + pocketApiVersion + "/" + pocketApiName);
        } catch (URISyntaxException e) {
            LOGGER.error("Fatal error, check the API endpoint");
            throw e;
        }

        return uri;
    }

    public static String getSavedUrlsRequest(String consumerKey, String accessToken, SavedUrlsRequest savedUrlsRequest) {
        savedUrlsRequest.setConsumer_key(consumerKey);
        savedUrlsRequest.setAccess_token(accessToken);
        return GsonSingleton.getInstance().toJson(savedUrlsRequest);
    }
}
