package org.b14.trivialarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import static org.b14.trivialarm.Tab2Fragment.TEXT_REQUEST;


/**
 * Created by colinaxner on 10/7/17.
 */

public class AddQuestionActivity extends AppCompatActivity {
    private static final String TAG = "AddQuestionActivity";
    private SectionsPageAdapter qSectionsPageAdapter;
    private ViewPager qViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        Log.d(TAG, "onCreate: Starting.");
        qSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        qViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(qViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(qViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShortAnswerTabFragment(), "Short Answer");
        adapter.addFragment(new MCTabFragment(), "Multiple Choice");
        viewPager.setAdapter(adapter);
    }


    public void closeActivity (View view) {
        finish();
    }


}
