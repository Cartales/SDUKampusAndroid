package com.example.zulkuf.sdukampus.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zulkuf on 15/03/17.
 */

public class Photos implements JSONPopulator {
    private String backgroundImage;

    public String getBackgroundImage() {
        return backgroundImage;
    }

    @Override
    public void populate(JSONObject data) {


        try {
            JSONArray array = data.getJSONArray("Photos");
            for (int i = 0; i < 3; i++) {
                Log.i("JSONA",array.getJSONObject(i).toString());
                backgroundImage = array.getJSONObject(i).optString("LandscapeLink");
                
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
