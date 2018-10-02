package com.pjs.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSingleton {
    private static final String YYYY_MM_DD = "YYYY-mm-dd";
    private static Gson gson = new GsonBuilder().setDateFormat(YYYY_MM_DD).setLenient().create();

    public static Gson getInstance() {
        return gson;
    }
}
