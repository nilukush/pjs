package com.pjs.client.reqresp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequestLogin extends RequestBase {
    private String code;
}
