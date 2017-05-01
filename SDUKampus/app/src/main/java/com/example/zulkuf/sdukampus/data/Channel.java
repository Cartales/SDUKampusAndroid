package com.example.zulkuf.sdukampus.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by zulkuf on 10/03/17.
 */

public class Channel implements JSONPopulator {
    private Metric metric;
    private Photos photos;
    private String weatherText;
    private int weatherIcon;

    public String getWeatherText() {
        return weatherText;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public Metric getMetric() {
        return metric;
    }

    public Photos getPhotos() {
        return photos;
    }

    @Override
    public void populate(JSONObject data) {
        Log.e("CHANNEL",data.toString());
        metric = new Metric();
        metric.populate(data.optJSONObject("Temperature").optJSONObject("Metric"));

        weatherText = data.optString("WeatherText");
        weatherIcon = data.optInt("WeatherIcon");

            photos = new Photos();
            photos.populate(data);
    }
}
