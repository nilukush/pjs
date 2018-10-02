package com.pjs.requestor.builder;

import com.pjs.config.ClientConfig;
import com.pjs.requestor.DefaultHttpRequestor;
import com.pjs.requestor.HttpRequestor;

public class DefaultHttpRequestorBuilder implements HttpRequestorBuilder {
    /**
     * Get an instance of a http requestor
     *
     * @return instance of http requestor
     */
    @Override
    public HttpRequestor build() {
        return new DefaultHttpRequestor();
    }

    public HttpRequestor build(ClientConfig clientConfig) {
        return new DefaultHttpRequestor(clientConfig);
    }
}
