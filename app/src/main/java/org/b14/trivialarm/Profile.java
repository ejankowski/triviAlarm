package org.b14.trivialarm;

import android.os.Parcelable;
import android.os.Parcel;

/**
 * Created by Eric on 10/7/17.
 */

public class Profile implements Parcelable {

    /////////////////////////////
    //  Begin Parcelable APIs  //
    /////////////////////////////

    public static final int CONTENTS_FILE_DESCRIPTOR = 1618;

    private Profile(Parcel in) {
        Deck deck = in.readParcelable(getClass().getClassLoader());
        setDeck(deck);
        setName(in.readString());
        setPoints(in.readInt());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // is this usage of flags correct?
        dest.writeParcelable(deck, flags);
        dest.writeString(name);
        dest.writeInt(points);
    }

    @Override
    public int describeContents() {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    /////////////////////////////
    //   End Parcelable APIs   //
    /////////////////////////////

    private Deck deck;
    private String name;
    private int points;

    public Profile(String name) {
        resetDeck();
        setName(name);
        setPoints(0);
    }

    public void setDeck(Deck d) {
        deck = d;
    }

    public void resetDeck() {
        setDeck(new Deck());
    }

    public Deck getDeck() {
        return deck;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public int setPoints(int p) {
        points = p;
        return p;
    }

    public int addPoints(int p) {
        return setPoints(points + p);
    }

    public int removePoints(int p) {
        return setPoints(points - p);
    }

    public int getPoints() {
        return points;
    }

}
