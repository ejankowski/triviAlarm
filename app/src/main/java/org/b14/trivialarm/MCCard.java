package org.b14.trivialarm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eric on 10/7/17.
 */

public class MCCard extends Card {

    String[] options;
    int answerIndex;
    public final int CONTENTS_FILE_DESCRIPTOR = 1303;

    public MCCard(String subject, String question, String[] options, int answerIndex) {
        setSubject(subject);
        setQuestion(question);
        setOptions(options);
        setAnswerIndex(answerIndex);
    }

    private MCCard(Parcel in) {
        setSubject(in.readString());
        setQuestion(in.readString());
        setOptions(in.createStringArray());
        setAnswerIndex(in.readInt());
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(subject);
        dest.writeString(question);
        dest.writeStringArray(options);
        dest.writeInt(answerIndex);
    }

    public static final Parcelable.Creator<MCCard> CREATOR = new Parcelable.Creator<MCCard>() {
        public MCCard createFromParcel(Parcel in) {
            return new MCCard(in);
        }
        public MCCard[] newArray(int size) {
            return new MCCard[size];
        }
    };
}
