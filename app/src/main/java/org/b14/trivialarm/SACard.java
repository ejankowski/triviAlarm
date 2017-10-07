package org.b14.trivialarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eric on 10/7/17.
 */

public class SACard extends Card {

    private String answer;
    public final int CONTENTS_FILE_DESCRIPTOR = 1901;

    public SACard(String subject, String question, String answer) {
        setSubject(subject);
        setQuestion(question);
        setAnswer(answer);
    }

    private SACard(Parcel in) {
        setSubject(in.readString());
        setQuestion(in.readString());
        setAnswer(in.readString());
    }

    public void setAnswer(String a) {
        answer = a;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkResponse(String response) {
        return response.equals(answer);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subject);
        dest.writeString(question);
        dest.writeString(answer);
    }

    public static final Parcelable.Creator<SACard> CREATOR = new Parcelable.Creator<SACard>() {
        public SACard createFromParcel(Parcel in) {
            return new SACard(in);
        }
        public SACard[] newArray(int size) {
            return new SACard[size];
        }
    };

}
