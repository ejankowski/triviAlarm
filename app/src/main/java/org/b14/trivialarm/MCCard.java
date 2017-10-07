package org.b14.trivialarm;

import java.util.HashMap;

/**
 * Created by Eric on 10/7/17.
 */

public class MCCard extends Card {

    String[] options;

    public MCCard(String subject, String question, String[] options, int answerIndex) {
        setSubject(subject);
        setQuestion(question);
        setOptions(options);
        setAnswer(options[answerIndex]);
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

    public boolean checkResponse(int index) {
        return answer.equals(getOption(index));
    }

}
