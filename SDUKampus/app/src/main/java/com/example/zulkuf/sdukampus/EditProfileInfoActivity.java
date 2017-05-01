package com.example.zulkuf.sdukampus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by YunusEmre on 1.5.2017.
 */

public class EditProfileInfoActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Bitmap bitmap;
    private ImageView editProfilePhoto;
    private TextView editProfileName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_info_activity);
        editProfilePhoto = (ImageView) findViewById(R.id.ProfileInfoPhoto);
        editProfileName = (TextView) findViewById(R.id.ProfileInfoName);

        /*
        Bundle bProfileInfo = getIntent().getExtras();
        String profileName = (String) bProfileInfo.get("NAME");
        String profilePhoto = (String) bProfileInfo.get("PHOTO");

        editProfileName.setText(profileName);
        */
    }
    public void onClick(View View) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            try {
                // recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                editProfilePhoto.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
    }
}
