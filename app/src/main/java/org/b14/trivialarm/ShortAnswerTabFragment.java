package org.b14.trivialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_OK;

/**
 * Created by colinaxner on 10/7/17.
 */

public class ShortAnswerTabFragment extends Fragment {

    private Button submit;
    public final static String SUBJECT = "Subject";
    public final static String QUESTION = "Question";
    public final static String ANSWER = "Answer";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.satab_fragment, container, false);

        submit = view.findViewById(R.id.submitSAButton);
        Log.d("HELP", "ME");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText sub = getView().findViewById(R.id.subjectInput);

                EditText q = getView().findViewById(R.id.questionInput);

                EditText a = getView().findViewById(R.id.answerInput);

                String subject, answer, question;
                subject = answer = question = "";

                if (sub != null || q != null || a != null) {
                    subject = sub.getText().toString();
                    question = q.getText().toString();
                    answer = a.getText().toString();
                    Log.d("Fragment", question);
                }
                Intent returnIntent = new Intent();
                returnIntent.putExtra(SUBJECT, subject);
                returnIntent.putExtra(QUESTION, question);
                returnIntent.putExtra(ANSWER, answer);
                getActivity().setResult(RESULT_OK,returnIntent);
                ((AddQuestionActivity) getActivity()).closeActivity(getView());

            }
        });
        return view;
    }

}