package com.pjs.client.reqresp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequestAuthorize extends RequestBase {
    private String redirect_uri;
}
