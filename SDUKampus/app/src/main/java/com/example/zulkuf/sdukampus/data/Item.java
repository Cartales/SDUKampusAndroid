package com.example.zulkuf.sdukampus.data;

import org.json.JSONObject;

/**
 * Created by zulkuf on 10/03/17.
 */

public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
