package com.pjs.client.reqresp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SavedUrlsRequest extends BaseRequest {
    private String detailType = "complete";
    private Integer count = 10;
    private Integer offset = 1;
}
