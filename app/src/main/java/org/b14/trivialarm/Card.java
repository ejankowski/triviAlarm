package org.b14.trivialarm;

/**
 * Created by Eric on 10/7/17.
 */

public abstract class Card {
    String subject, question, answer;

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

    public void setAnswer(String a) {
        answer = a;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean checkResponse(String response) {
        return response.equals(answer);
    }





}
