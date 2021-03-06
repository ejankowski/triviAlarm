package org.b14.trivialarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eric on 10/7/17.
 */

public abstract class Card implements Parcelable {

    private String subject, question;

    public void setSubject(String s) {
        subject = s;
    }

    public String getSubject() {
        return subject;
    }

    public void setQuestion(String q) {
        question = q;
    }

    public String getQuestion() {
        return question;
    }

    public abstract boolean checkResponse(String shortAnswer, int option);
}
