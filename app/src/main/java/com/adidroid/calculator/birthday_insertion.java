package com.adidroid.calculator;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;

public class birthday_insertion extends AppCompatActivity {
    private static String TAG = "Create User";

    EditText name;
    DatePicker bday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_insert);

        name = (EditText)findViewById(R.id.fname);
        bday = (DatePicker)findViewById(R.id.bday);

    }

    public void onInsert(View view){
        Log.d("myapp","on insert");
        appDatabase db = Room.databaseBuilder(getApplicationContext(),appDatabase.class,"birthdays")
                .allowMainThreadQueries()
                .build();

        String _name = name.getText().toString();
        Date _bday = new Date(bday.getYear()-1900,bday.getMonth(),bday.getDayOfMonth());
        SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        Log.d("DATE FORMAT: ",dtf.format(_bday));
        db.personDao().insertAll(new Person(_name,dtf.format(_bday).toString()));

    }
}
