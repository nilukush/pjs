package com.pjs.client.reqresp;

import lombok.Data;

@Data
public class ResponseLogin {
    private String access_token;
    private String username;
}
