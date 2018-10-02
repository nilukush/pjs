package com.pjs.requestor;

import com.pjs.config.ClientConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.CharsetUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;

@EqualsAndHashCode(callSuper = true)
@Data
public class DefaultHttpRequestor extends HttpRequestor {
    private static final Logger LOGGER = LogManager.getLogger(DefaultHttpRequestor.class);

    public DefaultHttpRequestor() {
    }

    public DefaultHttpRequestor(ClientConfig clientConfig) {
        super(clientConfig);
    }

    /**
     * Post reqresp
     *
     * @param uri  endpoint of the API
     * @param body reqresp body
     * @return response from API
     */
    @Override
    public String post(URI uri, String body) {
        try {
            return Request.Post(uri).useExpectContinue().version(clientConfig.httpVersion).bodyString(body, clientConfig.contentType).execute()
                    .returnContent().asString(CharsetUtils.lookup(clientConfig.charset));
        } catch (IOException e) {
            LOGGER.error("Failed to execute post reqresp [uri] " + uri + " [body] " + body);
        }

        return StringUtils.EMPTY;
    }
}
