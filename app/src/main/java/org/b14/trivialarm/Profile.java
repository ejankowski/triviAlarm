package org.b14.trivialarm;

/**
 * Created by Eric on 10/7/17.
 */

public class Profile {

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
