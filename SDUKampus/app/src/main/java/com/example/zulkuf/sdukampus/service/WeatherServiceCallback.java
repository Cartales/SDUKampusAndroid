package com.example.zulkuf.sdukampus.service;

import com.example.zulkuf.sdukampus.data.Channel;

/**
 * Created by zulkuf on 10/03/17.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
