package com.pjs.client.reqresp;

import com.pjs.core.model.PocketItem;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseSavedUrls {
    private Integer status;
    private List<Map<String, PocketItem>> list;
}
