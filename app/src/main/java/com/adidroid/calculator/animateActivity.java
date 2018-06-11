package com.adidroid.calculator;

import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import static android.support.constraint.ConstraintSet.WRAP_CONTENT;

public class animateActivity extends AppCompatActivity {
    ConstraintLayout cl;
    private int setCount = 0;


    private static int TOP = 3;
    private static int BOTTOM = 4;
    private static int START = 6;
    private static int END = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);

        cl = findViewById(R.id.noxml);
        cl.setBackgroundResource(R.color.colorBlack);

        final Transition mTransition = new ChangeBounds();
        mTransition.setDuration(1000); // todo: make the duration a function of the distance

        mTransition.setInterpolator(new BounceInterpolator());

        final ConstraintSet set1 = new ConstraintSet();
        final ConstraintSet set2 = new ConstraintSet();
        final ConstraintSet set3 = new ConstraintSet();

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setCount = (setCount + 1) % 3;

                switch (setCount) {
                    case 0:
                        set3.applyTo(cl);
                        break;
                    case 1:
                        set1.applyTo(cl);
                        break;
                    case 2:
                        set2.applyTo(cl);
                        break;
                }
                TransitionManager.beginDelayedTransition(cl, mTransition);
            }
        });

        TextView green = createTextView();
        green = init(green.getId(), "GREEN", R.color.colorGreen, R.color.colorBlack);
        set1.constrainHeight(green.getId(), WRAP_CONTENT);
        set1.constrainWidth(green.getId(), WRAP_CONTENT);
        set1.centerVertically(green.getId(), R.id.noxml);
        set1.centerHorizontally(green.getId(), R.id.noxml);
        createConstraintSet(green.getId(), R.id.noxml, set3, END, END, TOP, TOP);
        set3.connect(green.getId(), BOTTOM, R.id.noxml, BOTTOM);
        set3.setMargin(green.getId(), 7, 30);


        TextView yellow = createTextView();
        yellow = init(yellow.getId(), "YELLOW", R.color.colorYellow, R.color.colorBlack);
        createConstraintSet(yellow.getId(), green.getId(), set1, START, START, BOTTOM, TOP);
        createConstraintSet(yellow.getId(), green.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(yellow.getId(), green.getId(), set3, END, START, BOTTOM, TOP);

        TextView orange = createTextView();
        orange = init(orange.getId(), "ORANGE", R.color.colorOrange, R.color.colorBlack);
        createConstraintSet(orange.getId(), yellow.getId(), set1, START, START, BOTTOM, TOP);
        createConstraintSet(orange.getId(), yellow.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(orange.getId(), yellow.getId(), set3, END, START, BOTTOM, TOP);

        TextView red = createTextView();
        red = init(red.getId(), "RED", R.color.colorRed, R.color.colorBlack);
        createConstraintSet(red.getId(), orange.getId(), set1, START, START, BOTTOM, TOP);
        createConstraintSet(red.getId(), orange.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(red.getId(), orange.getId(), set3, END, START, BOTTOM, TOP);


        TextView blue = createTextView();
        blue = init(blue.getId(), "BLUE", R.color.colorBlue, R.color.colorNumber);
        createConstraintSet(blue.getId(), green.getId(), set1, START, START, TOP, BOTTOM);
        createConstraintSet(blue.getId(), green.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(blue.getId(), green.getId(), set3, END, START, TOP, BOTTOM);


        TextView indigo = createTextView();
        indigo = init(indigo.getId(), "INDIGO", R.color.colorIndigo, R.color.colorNumber);
        createConstraintSet(indigo.getId(), blue.getId(), set1, START, START, TOP, BOTTOM);
        createConstraintSet(indigo.getId(), blue.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(indigo.getId(), blue.getId(), set3, END, START, TOP, BOTTOM);

        TextView violet = createTextView();
        violet = init(violet.getId(), "VIOLET", R.color.colorViolet, R.color.colorBlack);
        createConstraintSet(violet.getId(), indigo.getId(), set1, START, START, TOP, BOTTOM);
        createConstraintSet(violet.getId(), indigo.getId(), set2, START, START, BOTTOM, BOTTOM);
        createConstraintSet(violet.getId(), indigo.getId(), set3, END, START, TOP, BOTTOM);

        set1.applyTo(cl);
        set2.applyTo(cl);
        set3.applyTo(cl);
    }

    private TextView init(@IdRes int viewId, String s, int color, int tc) {
        TextView tv = new TextView(this);
        tv.setId(viewId);
        tv.setText(s);
        tv.setTextSize(20);
        tv.setBackgroundResource(color);
        tv.setTextColor(getResources().getColor(tc));
        tv.setPadding(30, 20, 30, 20);
        cl.addView(tv);
        return tv;
    }

    private TextView createTextView() {
        TextView tv = new TextView(this);
        tv.setId(View.generateViewId());
        return tv;
    }

    private ConstraintSet createConstraintSet(@IdRes int viewId, @IdRes int parentId, ConstraintSet set, int start, int end, int start2, int end2) {
        set.constrainHeight(viewId, WRAP_CONTENT);
        set.constrainWidth(viewId, WRAP_CONTENT);
        set.connect(viewId, start, parentId, end);
        set.connect(viewId, start2, parentId, end2);
        return set;
    }
}
