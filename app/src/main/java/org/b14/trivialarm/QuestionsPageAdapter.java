package org.b14.trivialarm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by colinaxner on 10/7/17.
 */

public class QuestionsPageAdapter extends BaseAdapter {
    private final Deck data;
    private Context context;
    private LayoutInflater layoutInflater;
    private int size = 0;
    private ArrayList<Card> items;


    public QuestionsPageAdapter(Deck data, Context context) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        items = new ArrayList<>();
    }

    public void addSAQuestion(String subject, String question, String answer) {
        Card  card = new SACard(subject, question, answer);
        size+=1;
        data.addCard(card);
        items.add(card);
        Log.d("ADAPTER", question);
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MyViewHolder mViewHolder;
        Log.d("FUCK", "ME");
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_layout, viewGroup, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Card currentListData = (Card)getItem(i);
        Log.d("VIEWW", currentListData.getQuestion());
        mViewHolder.question.setText(currentListData.getQuestion());

        return convertView;
    }
    private class MyViewHolder {
        TextView question;

        public MyViewHolder(View item) {
            question = (TextView) item.findViewById(R.id.questionViewList);
        }
    }
}
