package com.pjs.client;

import com.pjs.client.reqresp.*;
import com.pjs.config.ClientConfig;
import com.pjs.core.GsonSingleton;
import com.pjs.core.PocketApiNames;
import com.pjs.requestor.factory.HttpRequestorFactory;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.net.URISyntaxException;
import java.util.Objects;

public class PocketClient {
    private ClientConfig clientConfig = null;

    public PocketClient(String consumerKey) {
        clientConfig = new ClientConfig();
        clientConfig.setConsumerKey(consumerKey);
    }

    public PocketClient(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    public static void main(String[] args) {
        RequestAuthorize requestAuthorize = getRequestAuthorize();
        ResponseAuthorize authorize = null;
        try {
            authorize = getPocketClient().authorize(requestAuthorize);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println(Objects.requireNonNull(authorize).getCode());
    }

    @NotNull
    private static PocketClient getPocketClient() {
        return new PocketClient("80908-b39061ed0999bb292f0fe716");
    }

    @NotNull
    private static RequestAuthorize getRequestAuthorize() {
        RequestAuthorize requestAuthorize = new RequestAuthorize();
        requestAuthorize.setRedirect_uri("https://nilukush.tumblr.com");
        return requestAuthorize;
    }

    /**
     * @param requestSavedUrls
     * @return
     * @throws URISyntaxException
     */
    public ResponseSavedUrls getSavedUrls(RequestSavedUrls requestSavedUrls) throws URISyntaxException {
        String post = HttpRequestorFactory.getHttpRequestor(clientConfig).post(UtilPocketClient.getUri(PocketApiNames.PAN_GET),
                UtilPocketClient.getRequestSavedUrls(this.clientConfig.getConsumerKey(), requestSavedUrls));

        return GsonSingleton.getInstance().fromJson(post, ResponseSavedUrls.class);
    }

    /**
     * @param requestAuthorize
     * @return
     * @throws URISyntaxException
     */
    public ResponseAuthorize authorize(RequestAuthorize requestAuthorize) throws URISyntaxException {
        String post = HttpRequestorFactory.getHttpRequestor(clientConfig).post(UtilPocketClient.getUri(PocketApiNames.PAN_OAUTH_REQUEST),
                UtilPocketClient.getRequestAuthorize(this.clientConfig.getConsumerKey(), requestAuthorize));

        return GsonSingleton.getInstance().fromJson(post, ResponseAuthorize.class);
    }

    /**
     * @param requestLogin
     * @return
     * @throws URISyntaxException
     */
    public ResponseLogin login(RequestLogin requestLogin) throws URISyntaxException {
        String post = HttpRequestorFactory.getHttpRequestor(clientConfig).post(UtilPocketClient.getUri(PocketApiNames.PAN_OAUTH_AUTHORIZE),
                UtilPocketClient.getRequestLogin(this.clientConfig.getConsumerKey(), requestLogin));

        return GsonSingleton.getInstance().fromJson(post, ResponseLogin.class);
    }
}
