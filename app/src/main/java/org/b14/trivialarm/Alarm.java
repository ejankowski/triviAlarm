package org.b14.trivialarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by ShravanKumaran on 10/7/17.
 */

public class Alarm {

    AlarmManager alarmManager;
    private int hour;
    private int minute;
    private PendingIntent pendingIntent;
    private Card card;
    private Calendar calendar;
    private boolean on;

    public Alarm(int h, int m, PendingIntent p, Card c) {
        hour = h;
        minute = m;
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        pendingIntent = p;
        card = c;
        on = false;
    }

    public void alarmOn() {
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        on = true;
    }

    public void alarmOff() {
        alarmManager.cancel(pendingIntent);
        on = false;
    }

    public Card getCard() {
        return card;
    }

    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public boolean isOn() {
        return on;
    }
}