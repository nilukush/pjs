package com.pjs.requestor.builder;

import com.pjs.requestor.HttpRequestor;

public interface HttpRequestorBuilder {
    /**
     * Get an instance of a http requestor
     *
     * @return instance of http requestor
     */
    HttpRequestor build();
}
