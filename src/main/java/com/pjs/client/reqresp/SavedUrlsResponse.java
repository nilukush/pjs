package com.pjs.client.reqresp;

import com.pjs.core.model.PocketItem;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SavedUrlsResponse {
    private Integer status;
    private List<Map<String, PocketItem>> pocketItems;
}
