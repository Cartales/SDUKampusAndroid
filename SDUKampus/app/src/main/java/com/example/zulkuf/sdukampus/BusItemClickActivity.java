package com.example.zulkuf.sdukampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * Created by YunusEmre on 24.4.2017.
 */

public class BusItemClickActivity extends AppCompatActivity {

    public TextView tv1Click, tv2Click, tv3Click;
    RelativeLayout relative;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_item_click_activity);

        relative = (RelativeLayout) findViewById(R.id.rlBusItemContent);
        tv1Click = (TextView) findViewById(R.id.tvBusClickNumber);
        tv2Click = (TextView) findViewById(R.id.tvBusClickTime);


        Bundle texts = getIntent().getExtras();
        String route = (String) texts.get("ROUTE");
        String number = (String) texts.get("NUMBER");
        String time = (String) texts.get("TIME");
        String[] routes = route.split("-");

        tv1Click.setText(number);
        tv2Click.setText(time);
        for (int i = 0; i < routes.length; i++) {

            TextView tv = new TextView(this);
            tv.setId(i);
            tv.setText("* " + routes[i]);
            RelativeLayout.LayoutParams lp = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (i > 0) {
                lp.addRule(RelativeLayout.BELOW, i - 1);
            }
            tv.setPadding(50,30,0,0);
            tv.setLayoutParams(lp);

            relative.addView(tv);

        }


    }

}
