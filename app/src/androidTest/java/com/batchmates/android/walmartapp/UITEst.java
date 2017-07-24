package com.batchmates.android.walmartapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.batchmates.android.walmartapp.view.activities.mainactivity.MainActivity;
import com.batchmates.android.walmartapp.view.activities.mainactivity.RecyclerViewAdapter;
import com.batchmates.android.walmartapp.view.activities.secondactivity.Main2Activity;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Android on 7/23/2017.
 */
@RunWith(AndroidJUnit4.class)
public class UITEst {

    String tobeTyped;


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setup()
    {
        tobeTyped="tv";

    }
    @Test
    public void checkEditText()
    {
        onView(withId(R.id.tietWhatYouWant)).perform(typeText(tobeTyped));

        onView(withId(R.id.btnToSearch)).perform(click());

        onView(withId(R.id.rvRecyclerList)).check(matches(Matchers.notNullValue()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rvRecyclerList)).perform(swipeUp());
        onView(withId(R.id.rvRecyclerList)).perform(swipeDown());
        onView(withId(R.id.rvRecyclerList)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rvSelectedItem)).perform(swipeLeft());
        onView(withId(R.id.rvSelectedItem)).perform(swipeRight());
    }

}
