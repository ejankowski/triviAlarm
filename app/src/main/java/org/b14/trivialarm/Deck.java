package org.b14.trivialarm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Eric on 10/7/17.
 */

public class Deck {

    private Random randomGenerator;
    private HashMap<String, ArrayList<Card>> container;
    private String[] defaultSubjects = {"Math", "Science", "History", "Literature"};

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
}
