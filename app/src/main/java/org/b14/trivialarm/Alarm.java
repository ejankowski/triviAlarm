package org.b14.trivialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.icu.util.Calendar;
import android.widget.TextView;


/**
 * Created by ShravanKumaran on 10/7/17.
 */

public class Alarm {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private Calendar calendar;
    private Card card;

    public Alarm(int hour, int minute, PendingIntent p, Card c) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        pendingIntent = p;
        card = c;
    }

    public void alarmOn() {
        alarmManager.setExact(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
    }

    public void alarmOff() {
        alarmManager.cancel(pendingIntent);
    }

}