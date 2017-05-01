package com.example.zulkuf.sdukampus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by YunusEmre on 1.5.2017.
 */

public class ClickEditProfileInfo extends AppCompatActivity {

    private ImageView imageView;
    private TextView profile_name;
    private TextView editProfileInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header);
        imageView = (ImageView) findViewById(R.id.profile_photo);
        profile_name = (TextView) findViewById(R.id.profileName);
        editProfileInfo = (TextView) findViewById(R.id.editProfile);

        Intent intent = new Intent(getApplicationContext(), EditProfileInfoActivity.class);

        String psrc = imageView.getContext().getResources().toString();

        intent.putExtra("PHOTO", psrc.toString());
        intent.putExtra("NAME", profile_name.getText().toString());
        startActivity(intent);



        /*
        editProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditProfileInfoActivity.class);

                String psrc = imageView.getContext().getResources().toString();

                intent.putExtra("PHOTO", psrc.toString());
                intent.putExtra("NAME", profile_name.getText().toString());
                startActivity(intent);

            }
        });
        */
    }
}

