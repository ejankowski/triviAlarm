package org.b14.trivialarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by colinaxner on 10/7/17.
 */

public class QuestionsPageAdapter extends BaseAdapter {
    private final Deck data;
    private Context context;
    private LayoutInflater layoutInflater;
    private int size;

    public QuestionsPageAdapter(Deck data, Context context) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addQuestion(boolean sa, String subject, String question,
                                String answer, String[] options, int answerIndex) {
        if (question.equals("")) {
            return;
        }
        Card card;
        if (sa) {
            card = new SACard(subject, question, answer);
        } else {
            card = new MCCard(subject, question, options, answerIndex);
        }
        size+=1;
        data.addCard(card);
    }
    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int i) {
        return data.cardList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.item, null);

        TextView txt=(TextView) convertView.findViewById(R.id.text);

        txt.setText(data[position]);



        return convertView;
    }
}
