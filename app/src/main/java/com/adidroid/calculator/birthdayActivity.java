package com.adidroid.calculator;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
    }

    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
            AppDatabase.class, "clog.db").build();
*/

public class birthdayActivity extends AppCompatActivity {
    EditText logInputText;
    TextView logOutputText;

    RecyclerView B_RecyclerView;
    LinearLayoutManager B_LayoutManager;
    B_Adapter b_adapter;
    List<CaptainsLogEntity> database_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_example);
        logInputText = findViewById(R.id.editText);
        logOutputText = findViewById(R.id.textView);


        //// new code ---

        B_RecyclerView= findViewById(R.id.recycle_birthdate);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        B_RecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        B_LayoutManager = new LinearLayoutManager(this);
        B_RecyclerView.setLayoutManager(B_LayoutManager);

//        LiveData<List<CaptainsLogEntity> receyled_birthday = CaptainsLogDb.getInstance(this).readCaptainsLog();
        List<CaptainsLogEntity> new_list = new ArrayList<CaptainsLogEntity>();
        b_adapter = new B_Adapter(new_list);
        B_RecyclerView.setAdapter(b_adapter);

        // specify an adapter (see also next example)
/*
        viewModel = ViewModelProviders.of(this).get(B_Adapter.B_ViewHolder.class);

        viewModel.getItemAndPersonList().observe(MainActivity.this, new Observer<List<CaptainsLogEntity>>() {
            @Override
            public void onChanged(@Nullable List<BorrowModel> itemAndPeople) {
                recyclerViewAdapter.addItems(itemAndPeople);
            }
        });
*/
/////////////////////////

        // Create the observer which updates the UI.
        final Observer<List<CaptainsLogEntity>> logObserver = new Observer<List<CaptainsLogEntity>>() {

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            // Create a calendar object that will convert the date and time value in milliseconds to date.
            Calendar calendar = Calendar.getInstance();
            StringBuilder sb = new StringBuilder();

            @Override
            public void onChanged(@Nullable final List<CaptainsLogEntity> newLog) {
                // Update the UI, in this case, a TextView.

                sb.setLength(0);
                for (CaptainsLogEntity cle : newLog) {
//                    calendar.setTimeInMillis(cle.time);
//                    sb.append(formatter.format(calendar.f()));
                    sb.append("birthdate : ");
                    sb.append(cle.birthdate);
//                    sb.append("-  ");
//                    sb.append(cle.log);
                    sb.append('\n');
                }

                logOutputText.setText(sb);
            }
        };

        LiveData<List<CaptainsLogEntity>> captainsLogEntityLiveData = CaptainsLogDb.getInstance(this).readCaptainsLog();

        captainsLogEntityLiveData.observe(this, logObserver);
    }

    public void onWriteClicked(View view) {
        String text = logInputText.getText().toString();
        if (!text.isEmpty()) {
            CaptainsLogEntity logEntity = new CaptainsLogEntity();
            logEntity.setLog(text);
            CaptainsLogDb.getInstance(this).writeToCaptainsLog(logEntity);
            logInputText.clearComposingText();
        }
    }


}
