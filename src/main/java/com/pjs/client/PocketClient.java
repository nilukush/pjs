package com.pjs.client;

import com.pjs.client.reqresp.SavedUrlsRequest;
import com.pjs.client.reqresp.SavedUrlsResponse;
import com.pjs.config.ClientConfig;
import com.pjs.core.GsonSingleton;
import com.pjs.core.PocketApiNames;
import com.pjs.requestor.factory.HttpRequestorFactory;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;

@Data
public class PocketClient {
    private static final Logger LOGGER = LogManager.getLogger(PocketClient.class);
    private String consumerKey = null;
    private String accessToken = null;
    private ClientConfig clientConfig = null;

    public PocketClient(String consumerKey, String accessToken) {
        init(consumerKey, accessToken, new ClientConfig());
    }

    private void init(String consumerKey, String accessToken, ClientConfig clientConfig) {
        this.consumerKey = consumerKey;
        this.accessToken = accessToken;
        this.clientConfig = clientConfig;
    }

    public PocketClient(String consumerKey, String accessToken, ClientConfig clientConfig) {
        init(consumerKey, accessToken, clientConfig);
    }

    public SavedUrlsResponse getSavedUrls(SavedUrlsRequest savedUrlsRequest) throws URISyntaxException {
        String post = HttpRequestorFactory.getHttpRequestor(clientConfig).post(UtilPocketClient.getUri(PocketApiNames.PAN_GET),
                UtilPocketClient.getSavedUrlsRequest(this.consumerKey, this.accessToken, savedUrlsRequest));

        return GsonSingleton.getInstance().fromJson(post, SavedUrlsResponse.class);
    }
}
