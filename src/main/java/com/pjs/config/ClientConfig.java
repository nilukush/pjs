package com.pjs.config;

import lombok.Data;
import org.apache.http.HttpVersion;
import org.apache.http.entity.ContentType;

/**
 *
 */
@Data
public class ClientConfig {
    public HttpVersion httpVersion = HttpVersion.HTTP_1_1;
    public ContentType contentType = ContentType.APPLICATION_JSON;
    public String charset = "UTF-8";
    private String consumerKey;
}
