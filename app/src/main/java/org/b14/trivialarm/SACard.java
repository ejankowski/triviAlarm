package org.b14.trivialarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eric on 10/7/17.
 */

public class SACard extends Card {

    /////////////////////////////
    //  Begin Parcelable APIs  //
    /////////////////////////////

    public static final int CONTENTS_FILE_DESCRIPTOR = 1901;

    public static final int x = 2;

    private SACard(Parcel in) {
        setSubject(in.readString());
        setQuestion(in.readString());
        setAnswer(in.readString());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getSubject());
        dest.writeString(getQuestion());
        dest.writeString(answer);
    }
    @Override
    public int describeContents() {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    public static final Parcelable.Creator<SACard> CREATOR = new Parcelable.Creator<SACard>() {
        public SACard createFromParcel(Parcel in) {
            return new SACard(in);
        }
        public SACard[] newArray(int size) {
            return new SACard[size];
        }
    };

    /////////////////////////////
    //   End Parcelable APIs   //
    /////////////////////////////

    private String answer;

    public SACard(String subject, String question, String answer) {
        setSubject(subject);
        setQuestion(question);
        setAnswer(answer);
    }

    public void setAnswer(String a) {
        answer = a;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean checkResponse(String shortAnswer, int option) {
        return shortAnswer.equals(answer);
    }
}
