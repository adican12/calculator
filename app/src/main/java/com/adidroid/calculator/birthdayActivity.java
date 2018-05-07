package com.adidroid.calculator;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_example);
        logInputText = findViewById(R.id.editText);
        logOutputText = findViewById(R.id.textView);

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
                    calendar.setTimeInMillis(cle.time);
                    sb.append(formatter.format(calendar.getTime()));
                    sb.append(": ");
                    sb.append(cle.log);
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
