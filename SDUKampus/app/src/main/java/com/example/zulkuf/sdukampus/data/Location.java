package com.example.zulkuf.sdukampus.data;

import org.json.JSONObject;

/**
 * Created by zulkuf on 10/03/17.
 */

public class Location implements JSONPopulator {
    private String city;

    public String getCity() {
        return city;
    }
    //Web service city değeri çekilir.
    @Override
    public void populate(JSONObject data) {
        city = data.optString("city");
    }
}
