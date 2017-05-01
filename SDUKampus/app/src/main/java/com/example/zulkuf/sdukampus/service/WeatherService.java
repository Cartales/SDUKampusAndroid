package com.example.zulkuf.sdukampus.service;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.zulkuf.sdukampus.data.Channel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import static android.R.id.input;

/**
 * Created by zulkuf on 09/03/17.
 */

public class WeatherService {
    private  WeatherServiceCallback callback;
    private String location;
    private Exception error;

    public WeatherService(WeatherServiceCallback callback) {
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

                String endpoint = "http://apidev.accuweather.com/currentconditions/v1/318032.json?language=tr-tr&apikey=hoArfRosT1215&getphotos=true";

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
                        result.append(line.replaceAll("\\[\\{\"LocalObservationDateTime", "\\{\"LocalObservationDateTime").replaceAll("lang=tr-tr\"\\}\\]","lang=tr-tr\"\\}"));
                        Log.i("KONTROL",result.toString());

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
                    //Query dizininin alt sizininden count a ulaş
                    Log.i("DATAKONTROL",data.toString());
                    String count = data.optString("WeatherIcon");


                    if (count == null){
                        Log.i("COUNT",count.toString());
                        callback.serviceFailure( new LocationWeatherException("Konum bilgisi bulunamadı "+location));
                        return;
                    }

                    //Channel sınıfından referans üret
                    Channel channel = new Channel();
                    //Channel classına channel parametresini gönder.
                    Log.d("COME",data.toString());
                    channel.populate(data);
                    callback.serviceSuccess(channel);

                } catch (JSONException e) {
                    callback.serviceFailure(e);
                }
            }
        }.execute();
    }

    public class LocationWeatherException extends Exception {
        public LocationWeatherException(String message) {
            super(message);
        }
    }
}
