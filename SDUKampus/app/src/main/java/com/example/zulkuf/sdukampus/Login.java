package com.example.zulkuf.sdukampus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

/**
 * Created by zulkuf on 06/03/17.
 */

public class Login extends Activity {
    //Nesneler tanımlandı.
    private EditText eMail,password;
    private Button login,signUp;

    public static final String SP = "preference";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //XML den componentler çekildi.
        eMail = (EditText)findViewById(R.id.eMail);
        password = (EditText)findViewById(R.id.password);

        login = (Button)findViewById(R.id.btnLogin);
        signUp = (Button) findViewById(R.id.btnSignUp);

        eMail.getText().toString();


        //Login butonuna tıklanma aksiyonu
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (eMail.getText().toString().equals("2") && password.getText().toString().equals("2")){
                   //Shared Preference Create
                   SharedPreferences preferences = getSharedPreferences(SP,0);
                   SharedPreferences.Editor editor = preferences.edit();
                    //Keep usermail and pass
                   editor.putString("userMessage", eMail.getText().toString());
                   editor.commit();

                   Intent intent = new Intent(Login.this,Home.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(getApplicationContext(),"Kullanıcı ya da şifre boş",Toast.LENGTH_SHORT).show();
               }
           }
       });

    }
}


