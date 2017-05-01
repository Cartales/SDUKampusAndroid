package com.example.zulkuf.sdukampus.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zulkuf on 10/03/17.
 */

public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        try {
            //Web service den temperature değeri çekilir.
            temperature = data.getString("temperature");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
