package com.example.zulkuf.sdukampus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.widget.EditText;

/**
 * Created by zulkuf on 06/03/17.
 */

public class SplashScreen extends Activity {

    public static final String SP = "preference";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread zaman = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    SharedPreferences shared = getSharedPreferences(SP,0);
                    String result = shared.getString("userMessage","Sorry");
                   if (result.equals("Sorry")){
                       Intent intent  = new Intent(getApplicationContext(),Login.class);
                       startActivity(intent);
                   }else{
                       Intent intent  = new Intent(getApplicationContext(),Home.class);
                       startActivity(intent);
                   }


                }

            }
        };
        zaman.start();
    }
}
