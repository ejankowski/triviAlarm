package org.b14.trivialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * Created by User on 2/28/2017.
 */

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    public static final int TEXT_REQUEST = 3;
    ListView lvDetail;

    private FloatingActionButton add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        add = view.findViewById(R.id.floatingActionButton2);

        lvDetail = (ListView) view.findViewById(R.id.list_view);
        QuestionsPageAdapter temp = ((MainActivity) getActivity()).getQPAdapter();
        temp.addSAQuestion("Default", "What is this app called?", "triviAlarm");
        lvDetail.setAdapter(temp);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageIntent = new Intent(getActivity(), AddQuestionActivity.class);
                getActivity().startActivityForResult(messageIntent, TEXT_REQUEST);
            }
        });

        return view;
    }

}

