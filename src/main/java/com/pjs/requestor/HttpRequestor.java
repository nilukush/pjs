package com.pjs.requestor;

import com.pjs.config.ClientConfig;
import lombok.Data;

import java.net.URI;

@Data
public abstract class HttpRequestor {
    protected ClientConfig clientConfig = new ClientConfig();

    HttpRequestor() {
    }

    HttpRequestor(ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    /**
     * Post reqresp
     *
     * @param uri  endpoint of the API
     * @param body reqresp body
     * @return response from API
     */
    public abstract String post(URI uri, String body);
}
