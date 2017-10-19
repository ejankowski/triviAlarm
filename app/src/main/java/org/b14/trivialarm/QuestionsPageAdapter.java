package org.b14.trivialarm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log; //useful
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/**
 * Adapter for RecyclerView
 */

public class QuestionsPageAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {
    private final Deck data;
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Card> items;
    private int size = 0;

    public QuestionsPageAdapter(Context context, Deck data) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        items = new ArrayList<>();
    }

    @Override
    public QuestionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Inflate an item view.
        View mItemView = layoutInflater.inflate(R.layout.list_layout, parent, false);
        return new QuestionsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(QuestionsViewHolder holder, int position) {
        // Retrieve the data for that position
        Card item = items.get(position);
        String mQuestion = item.getQuestion();
        String mSubject = item.getSubject();
        // Add the data to the view
        holder.questionItemView.setText(mQuestion);
        holder.subjectItemView.setText(mSubject);
        holder.setPosition(position);
    }

    @Override
    public void onViewRecycled(QuestionsViewHolder holder) {
        holder.itemView.setOnLongClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    /**
     * Adds the SA Question to the Database and Adapter stores it locally.
     * @param subject : Subject of the Question.
     * @param question : Question of the Short Answer Question
     * @param answer : Answer for the Question
     */
    public void addSAQuestion(String subject, String question, String answer) {
        Card card = new SACard(subject, question, answer);
        size++;
        data.addCard(card);
        items.add(card);
    }

    /**
     * Allows for the deletion of a question.
     * @param position : position of the item in the RecyclerView list.
     */
    public void deleteQuestion(int position) {
        items.remove(position);
        size--;
    }

}
