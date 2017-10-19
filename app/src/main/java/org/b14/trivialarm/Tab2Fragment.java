package org.b14.trivialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log; //useful for debugging
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * Questions Fragment Page. Main Function of this page include: displaying currently stored questions
 * and providing the options to add and delete a question from storage. To delete you would
 * hold down on the question and to add you press the flaoting button.
 */

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment"; //For Log use
    public static final int TEXT_REQUEST = 3; //For Intent used
    protected RecyclerView mRecyclerView; //The List of questions are displayed by this view
    protected QuestionsPageAdapter mAdapter; //Adapter for RecyclerView

    private FloatingActionButton add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        add = view.findViewById(R.id.floatingActionButton2);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = ((MainActivity) getActivity()).getQPAdapter();

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        registerForContextMenu(mRecyclerView);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(getActivity(), AddQuestionActivity.class);
                getActivity().startActivityForResult(messageIntent, TEXT_REQUEST);
            }
        });

        return view;
    }

    public void deleteQuestion(MenuItem info) {
        mAdapter.deleteQuestion(info.getOrder());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getGroupId()) { //Gets Group Id which is set in QuestionsViewHolder
            case 0:
                deleteQuestion(item);
                return true;
        }
        return super.onContextItemSelected(item);
    }



}

