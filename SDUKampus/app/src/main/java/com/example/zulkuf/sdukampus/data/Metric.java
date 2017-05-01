package com.example.zulkuf.sdukampus.data;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by zulkuf on 15/03/17.
 */

public class Metric implements JSONPopulator {
    private int temperature;
    private String unit;

    public int getTemperature() {
        return temperature;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void populate(JSONObject data) {
        Log.d("METRIC",data.toString());

        temperature = data.optInt("Value");
        unit = data.optString("Unit");

    }
}
