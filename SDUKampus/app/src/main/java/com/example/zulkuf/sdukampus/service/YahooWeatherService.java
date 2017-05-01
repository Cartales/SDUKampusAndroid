package com.example.zulkuf.sdukampus.service;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.zulkuf.sdukampus.data.Channel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zulkuf on 09/03/17.
 */

public class YahooWeatherService {
    private  WeatherServiceCallback callback;
    private String location;
    private Exception error;

    public YahooWeatherService(WeatherServiceCallback callback) {
        this.callback = callback;
    }

    public String getLocation() {
        return location;
    }

    public void refreshWeather(String l){

        this.location = l;
        //Verileri çekmek için asynctask oluşturuldu.
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {

                String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\") and u='c'",strings[0]);
                String endpoint  = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

                Log.i("HATA",endpoint);

                try {
                    //Url Başlangıç
                    URL url = new URL(endpoint);
                    //Web Servis bağlantısı
                    URLConnection connection = url.openConnection();
                    InputStream inputStream  = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder result = new StringBuilder();
                    String line;
                        //Service ten gelen değer boş değil ise
                    while ((line = reader.readLine()) != null ){
                        result.append(line);
                    }

                    return result.toString();
                } catch (Exception e) {
                    error = e;
                }

                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                if (s == null && error != null){
                    callback.serviceFailure(error);
                    return;
                }

                try {
                    //JSON Nesnesi oluştur.
                    JSONObject data  = new JSONObject(s);
                    //Web service query dizinine ulaş
                    JSONObject queryResults = data.optJSONObject("query");
                    //Query dizininin alt sizininden count a ulaş
                    int count = queryResults.optInt("count");
                    if (count == 0){
                        callback.serviceFailure( new LocationWeatherException("Konum bilgisi bulunamadı "+location));
                        return;
                    }
                    //Channel sınıfından referans üret
                    Channel channel = new Channel();
                    //Channel classına channel parametresini gönder.
                    channel.populate(queryResults.getJSONObject("results").optJSONObject("channel"));
                    callback.serviceSuccess(channel);

                } catch (JSONException e) {
                    callback.serviceFailure(e);
                }
            }
        }.execute(location);
    }

    public class LocationWeatherException extends Exception {
        public LocationWeatherException(String message) {
            super(message);
        }
    }
}
