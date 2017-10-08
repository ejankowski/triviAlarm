package org.b14.trivialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static org.b14.trivialarm.Tab2Fragment.TEXT_REQUEST;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private QuestionsPageAdapter mQuestionsPageAdapter;

    private Deck deck;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        deck = new Deck();
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mQuestionsPageAdapter = new QuestionsPageAdapter(deck, this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Alarms");
        adapter.addFragment(new Tab2Fragment(), "Questions");
        adapter.addFragment(new Tab3Fragment(), "Feed");
        adapter.addFragment(new Tab4Fragment(), "Profile");
        viewPager.setAdapter(adapter);
    }

    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String sub = data.getStringExtra(ShortAnswerTabFragment.SUBJECT);
                String a = data.getStringExtra(ShortAnswerTabFragment.ANSWER);
                String q = data.getStringExtra(ShortAnswerTabFragment.QUESTION);
                Log.d(TAG, q);
                mQuestionsPageAdapter.addSAQuestion(sub, q, a);

            }
        }
    }

    public QuestionsPageAdapter getQPAdapter() {
        return mQuestionsPageAdapter;
    }
}

