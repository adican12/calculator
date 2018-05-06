package com.adidroid.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//import android.support.v7.widget.Adapter;
import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static ArrayList<MyListItem> hw = new ArrayList<>();
    static {
        hw.add(new MyListItem("homework 1 : Calculator Activity ",calcActivity.class));
        hw.add(new MyListItem("homework 2 : Birthday Activity ",calcActivity.class));
        //more homework..
    }

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    MyAdapter mAdapter;

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getBaseContext(), "Activity is not attached", Toast.LENGTH_LONG).show();
            MyListItem clicked = (MyListItem) view.getTag();
            if (clicked.getActivity() == null) {
                if (clicked.getPackageName() != null) {
                    // we need to launch a different app here, if it's available.
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage(clicked
                            .getPackageName());
                    if (launchIntent == null) {
                        Toast.makeText(getBaseContext(), "Couldn't find activity for package:" +
                                clicked.getActivity(), Toast.LENGTH_LONG).show();

                        // example for removing item from the list
                        // ---------------------------------------
                        // Notice that we need to remove from the Model (the array)
                        // and not from the ListView (the View)!
                        // The view will be updated after the  notifyDataSetChanged();
                        hw.remove(clicked);
                        mAdapter.notifyDataSetChanged();

                    } else {
                        startActivity(launchIntent);
                    }
                } else {
                    // nothing to do here
                    Toast.makeText(getBaseContext(), "Activity is not attached", Toast.LENGTH_LONG).show();
                }
            } else {
                Intent intent = new Intent(getBaseContext(), clicked.getActivity());
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        mRecyclerView = findViewById(R.id.homework);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(hw,mClickListener);
        mRecyclerView.setAdapter(mAdapter);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.lesson4, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        System.out.println("here onOptionsItemSelected");
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.mi_settings) {
////            Toast.makeText(getBaseContext(), "Todo: settings screen", Toast.LENGTH_LONG).show();
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    public void onPrefsClicked(View view) {
////        startActivity(new Intent(this, PrefsActivity.class));
//    }
}

