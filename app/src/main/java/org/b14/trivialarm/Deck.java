package org.b14.trivialarm;

import java.lang.reflect.Array;
import java.util.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.os.Bundle;
import java.util.Map.Entry;

/**
 * Created by Eric on 10/7/17.
 */

public class Deck implements Parcelable {

    /////////////////////////////
    //  Begin Parcelable APIs  //
    /////////////////////////////

    public static final int CONTENTS_FILE_DESCRIPTOR = 4311;

    private Deck(Parcel in) {
        randomGenerator = new Random();
        container = new HashMap<>();
        Bundle bundle = in.readBundle();
        for (String subject : bundle.keySet()) {
            ArrayList<Card> subDeck = bundle.getParcelableArrayList(subject);
            container.put(subject, subDeck);
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        for (Entry<String, ArrayList<Card>> entry : container.entrySet()) {
            bundle.putParcelableArrayList(entry.getKey(), entry.getValue());
        }
        dest.writeBundle(bundle);
    }

    @Override
    public int describeContents() {
        return CONTENTS_FILE_DESCRIPTOR;
    }

    public static final Parcelable.Creator<Deck> CREATOR = new Parcelable.Creator<Deck>() {
        public Deck createFromParcel(Parcel in) {
            return new Deck(in);
        }
        public Deck[] newArray(int size) {
            return new Deck[size];
        }
    };

    /////////////////////////////
    //   End Parcelable APIs   //
    /////////////////////////////

    private Random randomGenerator;
    private HashMap<String, ArrayList<Card>> container;
    private final String[] defaultSubjects = {"Math", "Science", "History", "Literature"};

    public Deck() {
        randomGenerator = new Random();
        container = new HashMap<>();
        for(String subject : defaultSubjects) {
            addSubDeck(subject);
        }
    }

    public void addSubDeck(String subject) {
        container.put(subject, new ArrayList<Card>());
    }

    public boolean containsSubDeck(String subject) {
        return container.containsKey(subject);
    }

    public ArrayList<Card> getSubDeck(String subject) {
        return container.get(subject);
    }

    public ArrayList<Card> removeSubDeck(String subject) {
        return container.remove(subject);
    }

    public void addCard(Card card) {
        String subject = card.getSubject();
        if (!container.containsKey(subject)) {
            addSubDeck(subject);
        }
        ArrayList<Card> subDeck = getSubDeck(subject);
        subDeck.add(card);
    }

    public Card getCardFrom(String subject) {
        ArrayList<Card> subDeck = getSubDeck(subject);
        int index = randomGenerator.nextInt(subDeck.size());
        return subDeck.get(index);
    }

    public boolean removeCard(Card card) {
        String subject = card.getSubject();
        if (containsSubDeck(subject)) {
            ArrayList<Card> subDeck = getSubDeck(subject);
            return subDeck.remove(card);
        }
        return false;
    }

    public ArrayList<Card> cardList() {
        ArrayList<Card> cards = new ArrayList<>();
        for (String s : container.keySet()) {
            cards.addAll(container.get(s));
        }
        return cards;
    }

}
