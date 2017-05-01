package com.example.zulkuf.sdukampus.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zulkuf.sdukampus.BusItemClickActivity;
import com.example.zulkuf.sdukampus.ListViewDenemesi;
import com.example.zulkuf.sdukampus.R;

/**
 * Created by zulkuf on 07/03/17.
 */

public class BusFragment extends Fragment {

    private String[] time  = {"07:30 - 23:30 | Hafta içi yoğunluğa göre çalışır.",
            "07:20 - 17:00 | Her on dakikada bir hareket eder.",
            "07:30 - 23:30 | Hafta içi yoğunluğa göre çalışır.",
            "06:30 - 23:30 | Hafta içi her yarım saatte bir hareket eder. ",
            "07:30 - 23:30 | Hafta sonu 4 ve 12 yerine çalışır.",
            "09:00 - 17:00 | Hafta içi her yarım saatte hareket eder.",
            "09:00 - 17:00 | Hafta içi her yarım saatte hareket eder."};

    private String[] location  = {"6 Mart Atatürk Caddesi Ana Durak - Özkanlar - " +
            "Orman Bölge Müdürlüğü - Otogar - Yeni Emniyet Müdürlüğü - Kipa - " +
            "Çünür Mahallesi - Batı Yerleşkesi | Dönüş: Geldiği İstikametin Tersi",

            "Otel Isparta Altı - Zübeyde Hanım Caddesi - Belediye - Subay Lojmanları - Otogar - " +
                    "Yeni Emniyet Müdürlüğü - Kolçelik Kavşağı - Kipa - Çünür - Tıp Fakültesi - " +
                    "Orman Fakultesi - Üniversite Kavşağı - Çünür Polis Karakolu - Özkanlar - " +
                    "Polat Otel - Çarşı - Camlı Cami - Devlet Hastanesi",

            "6 Mart Atatürk Caddesi Ana Durak - Özkanlar - " +
                    "Orman Bölge Müdürlüğü - Otogar - Yeni Emniyet Müdürlüğü - Kipa - " +
                    "Çünür Mahallesi Kapalı Spor Salonu - Orman Fakultesi - Doğu Yerleşkesi " +
                    "| Dönüş: Geldiği İstikametin Tersi",

            "Tuhafiyeciler Sitesi - Belediye - Subay Lojmanları - Otogar - " +
                    "Yeni Emniyet Müdürlüğü - Kolçelik Kavşağı - Kipa - " +
                    "Çünür Bölge Trafik - Diyanet Kız Öğrenci Yurdu -" +
                    "Mehmet Tönge Sağlık Ocağı - Mehmet Köse İ.Ö.O Kayı Köyü Caddesi - " +
                    "Özürlüler  Okulu - Ünikent - Merkez Durak | Dönüş: Geldiği İstikametin Tersi",

            "Mevlana",

            "Gidiş Yönü: Mavikent Merko - Batıkent Camii - 1001 Evler Ekmek Frını - " +
                    "Mavikent İ.Ö.O - Yağmur Sitesi - Asri Mezarlık - 244. Cadde - 155. Cadde - " +
                    "Gülistan Polis Karakolu - 111. Cadde - 127. Cadde - Beyaz Saray Öğrenci Yurdu - " +
                    "Miraç Camii - Turan Nakliyat - Deregüme Kavşağı - 215. Cadde - 202. Cadde - " +
                    "Zafer Kız Yurdu - Cuma Pazarı - Otogar - Selçuklı İ.Ö.O - " +
                    "Yeni Emniyet Müdürlüğü - Kipa - Çünür Mahallesi - Tıp Fakültesi - " +
                    "Doğu Yerleşkesi - Batı Yerleşkesi\n\n" +
                    "Dönüş Yönü: Batı Yerleşkesi - Çünür Mahallesi - Kipa - Yeni Emniyet Müdürlüğü - " +
                    "IYAŞPARK AVM - 156. Cadde - 209. Cadde - Zafer Kız Yurdu - 202. Cadde - " +
                    "M. Türkeş Mahallesi - İSPAŞ Belmaş Evleri - Batıkent Camii - " +
                    "Mavikent Merko",

            "Gidiş Yönü: Ayazmana Mesireliği - Halıkent Kapalı Pazar Yeri - Halıkent Telekom - " +
                    "Gülevler Üstü - M.Akif Ersoy İ.Ö.O - Belmaş Evleri - Fatih Kuran Kursu - " +
                    "Oktay Petrol - Cezaevi - Migros Kavşağı - Karayolları - Gülkent Devlet Hastenesi - " +
                    "Özkanlar - Orman Bölge Müdürlüğü - Otogar - Yeni Emniyet Müdürlüğü - Kipa - " +
                    "Çünür Mahallesi - Tıp Fakültesi - Doğu Yerleşkesi - Batı Yerleşkesi\n\n" +
                    "Dönüş Yönü: Batı Yerleşkesi - Çünür Mahallesi - Kipa - Yeni Emniyet Müdürlüğü - " +
                    "Orman Bölge Müdürlüğü - Özkanlar - Gülkent Devlet Hastanesi - Karayolları - " +
                    "Migros Kavşağı - Cezaevi - Yavuz Sitesi - Akyol Mezarlığı - Halıkent Telekom - " +
                    "Halıkent Kapalı Pazar Yeri - Ayazmana Mesireliği "};

    private String[] numbers  = {"4","8","12","18","37","46","47"};
    private ListView mBusList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bus_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBusList = (ListView)view.findViewById(R.id.busListView);
        MyArrayAdapter myArrayAdapter = new MyArrayAdapter(getContext());

        mBusList.setAdapter(myArrayAdapter);

        mBusList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv1 = (TextView)view.findViewById(R.id.tvBusNumber);
                TextView tv2 = (TextView)view.findViewById(R.id.tvBusTime);
                TextView tv3 = (TextView)view.findViewById(R.id.tvBusRoute);

                Intent intent = new Intent(getContext(), BusItemClickActivity.class);
                intent.putExtra("NUMBER",tv1.getText().toString());
                intent.putExtra("TIME",tv2.getText().toString());
                intent.putExtra("ROUTE",tv3.getText().toString());
                startActivity(intent);

            }

        });

    }

    private class MyArrayAdapter extends ArrayAdapter<String> {
        public MyArrayAdapter(@NonNull Context context) {
            super(context, R.layout.custom_bus_list_item,time);
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = layoutInflater.inflate(R.layout.custom_bus_list_item,parent,false);

            ImageView img = (ImageView)view.findViewById(R.id.ivBusNumberImage);
            TextView tv1 = (TextView)view.findViewById(R.id.tvBusTime);
            TextView tv2 = (TextView)view.findViewById(R.id.tvBusRoute);
            TextView tv3 = (TextView)view.findViewById(R.id.tvBusNumber);


            tv1.setText(time[position]);
            tv2.setText(location[position]);
            tv3.setText(numbers[position]);


            return view;
        }
    }
}
