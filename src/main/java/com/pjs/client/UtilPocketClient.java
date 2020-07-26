package com.pjs.client;

import com.pjs.client.reqresp.RequestAuthorize;
import com.pjs.client.reqresp.RequestBase;
import com.pjs.client.reqresp.RequestLogin;
import com.pjs.client.reqresp.RequestSavedUrls;
import com.pjs.core.GsonSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.URISyntaxException;

class UtilPocketClient {
    private static final Logger LOGGER = LogManager.getLogger(UtilPocketClient.class);
    private static final String baseEndpoint = "https://getpocket.com/";
    private static final String pocketApiVersion = "v3";

    /**
     *
     * @param pocketApiName
     * @return
     * @throws URISyntaxException
     */
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

    /**
     *
     * @param consumerKey
     * @param requestSavedUrls
     * @return
     */
    public static String getRequestSavedUrls(String consumerKey, @org.jetbrains.annotations.NotNull RequestSavedUrls requestSavedUrls) {
        setConsumerKey(consumerKey, requestSavedUrls);
        return GsonSingleton.getInstance().toJson(requestSavedUrls);
    }

    private static void setConsumerKey(String consumerKey, @NotNull RequestBase requestBase) {
        requestBase.setConsumer_key(consumerKey);
    }

    /**
     *
     * @param consumerKey
     * @param requestAuthorize
     * @return
     */
    public static String getRequestAuthorize(String consumerKey, @org.jetbrains.annotations.NotNull RequestAuthorize requestAuthorize) {
        setConsumerKey(consumerKey, requestAuthorize);
        return GsonSingleton.getInstance().toJson(requestAuthorize);
    }

    /**
     *
     * @param consumerKey
     * @param requestLogin
     * @return
     */
    public static String getRequestLogin(String consumerKey, RequestLogin requestLogin) {
        setConsumerKey(consumerKey, requestLogin);
        return GsonSingleton.getInstance().toJson(requestLogin);
    }
}
