package com.example.zulkuf.sdukampus.data;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by zulkuf on 10/03/17.
 */

public class Condition implements JSONPopulator {
    private int code;
    private int temperature;
    private String description;

    public int getCode() {
        return code;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    @Override

    public void populate(JSONObject data) {
        //Web service den code temp ve text dizinleri çekilir.
        code = data.optInt("code");
        temperature = data.optInt("temp");
        description = data.optString("text");


    }
}
