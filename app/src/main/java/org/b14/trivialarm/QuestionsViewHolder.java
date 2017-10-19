package org.b14.trivialarm;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

/**
 * ViewHolder for RecyclerView.
 */

class QuestionsViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
    TextView questionItemView;
    TextView subjectItemView;
    int position = -1;

    protected RecyclerView.Adapter mAdapter;

    public QuestionsViewHolder(View itemView, QuestionsPageAdapter adapter) {
        super(itemView);
        questionItemView = (TextView) itemView.findViewById(R.id.questionViewList);
        subjectItemView = itemView.findViewById(R.id.subjectViewList);
        this.mAdapter = adapter;
        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), position, "Delete");//groupId, itemId, order, title


    }

    /**
     * Sets positioning for Item in the RecyclerView List.
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
