package com.pjs.requestor.factory;

import com.pjs.config.ClientConfig;
import com.pjs.core.RequestorType;
import com.pjs.requestor.HttpRequestor;
import com.pjs.requestor.builder.DefaultHttpRequestorBuilder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class HttpRequestorFactory {
    private static Map<RequestorType, HttpRequestor> requestorTypeHttpRequestorMap = new HashMap<>();

    static {
        requestorTypeHttpRequestorMap.put(RequestorType.DEFAULT, new DefaultHttpRequestorBuilder().build());
    }

    public static HttpRequestor getHttpRequestor() {
        return new DefaultHttpRequestorBuilder().build();
    }

    public static HttpRequestor getHttpRequestor(ClientConfig clientConfig) {
        if (null == clientConfig) {
            return new DefaultHttpRequestorBuilder().build();
        }

        return new DefaultHttpRequestorBuilder().build(clientConfig);
    }

    public static HttpRequestor getHttpRequestor(RequestorType requestorType) {
        return requestorTypeHttpRequestorMap.get(requestorType);
    }

    public static HttpRequestor getHttpRequestor(RequestorType requestorType, ClientConfig clientConfig) {
        HttpRequestor httpRequestor = requestorTypeHttpRequestorMap.get(requestorType);
        if (null == httpRequestor) return null;

        httpRequestor.setClientConfig(clientConfig);
        return httpRequestor;
    }
}
