package com.example.zulkuf.sdukampus.fragments.pool;

/**
 * Created by zulkuf on 17/03/17.
 */

public class DaysList {
    private String[] time = {"09:00-10:15","10:30-11:45","12:00-13:15",
                             "13:30-14:45","14:45-15:15","15:30-16:45",
                             "17:00-18:15","18:30-19:45","20:00-21:15"};
    private String monday = "Temizlik - Bakım Günü";


    private String[] tuesday = {"Bay - Bayan","Bay","Bay - Bayan",
                               "Bay - Bayan","Bakım - Temizlik Saati","Bayan",
                               "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    private String[] wednesday = {"Bay - Bayan","Bayan","Bay - Bayan",
            "Bay - Bayan","Bakım - Temizlik Saati","Bay",
            "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    private String[] thursday = {"Bay - Bayan","Bay","Bay - Bayan",
            "Bay - Bayan","Bakım - Temizlik Saati","Bayan",
            "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    private String[] friday = {"Bay - Bayan","Bayan","Bay - Bayan",
            "Bay - Bayan","Bakım - Temizlik Saati","Bay",
            "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    private String[] saturday = {"Bay - Bayan","Bay","Bay - Bayan",
            "Bay - Bayan","Bakım - Temizlik Saati","Bayan",
            "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    private String[] sunday = {"Bay - Bayan","Bay","Bay - Bayan",
            "Bay - Bayan","Bakım - Temizlik Saati","Bayan",
            "Bay - Bayan","Bay - Bayan","Bay - Bayan"};

    public String getMonday() {
        return monday;
    }

    public String[] getTuesday() {
        return tuesday;
    }

    public String[] getWednesday() {
        return wednesday;
    }

    public String[] getThursday() {
        return thursday;
    }

    public String[] getFriday() {
        return friday;
    }

    public String[] getSaturday() {
        return saturday;
    }

    public String[] getSunday() {
        return sunday;
    }


    public String[] getTime() {
        return time;
    }
}
