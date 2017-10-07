package org.b14.trivialarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eric on 10/7/17.
 */

public class MCCard extends Card {

    /////////////////////////////
    //  Begin Parcelable APIs  //
    /////////////////////////////

    public static final int CONTENTS_FILE_DESCRIPTOR = 1303;

    public static final int x = 2;

    private MCCard(Parcel in) {
        setSubject(in.readString());
        setQuestion(in.readString());
        setOptions(in.createStringArray());
        setAnswerIndex(in.readInt());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getSubject());
        dest.writeString(getQuestion());
        dest.writeStringArray(options);
        dest.writeInt(answerIndex);
    }

    @Override
    public int describeContents() {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    public static final Parcelable.Creator<MCCard> CREATOR = new Parcelable.Creator<MCCard>() {
        public MCCard createFromParcel(Parcel in) {
            return new MCCard(in);
        }
        public MCCard[] newArray(int size) {
            return new MCCard[size];
        }
    };

    /////////////////////////////
    //   End Parcelable APIs   //
    /////////////////////////////

    private String[] options;
    private int answerIndex;

    public MCCard(String subject, String question, String[] options, int answerIndex) {
        setSubject(subject);
        setQuestion(question);
        setOptions(options);
        setAnswerIndex(answerIndex);
    }

    public void setOptions(String[] o) {
        options = o;
    }

    public String[] getOptions() {
        return options;
    }

    public String getOption(int index) {
        return options[index];
    }

    public void setAnswerIndex(int index) {
        answerIndex = index;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public String getAnswer() {
        return getOption(answerIndex);
    }

    public boolean checkResponse(int index) {
        return index == answerIndex;
    }
}
