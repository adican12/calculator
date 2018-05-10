package com.adidroid.calculator;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.adidroid.calculator.BirthdayInsertion;
import com.adidroid.calculator.Person;
import com.adidroid.calculator.PersonAdapter;
import com.adidroid.calculator.appDatabase;

import java.util.List;

public class birthdayActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acrivity_birthday_list);

        recyclerView = findViewById(R.id.recycler_view);

        appDatabase db = Room.databaseBuilder(getApplicationContext(),appDatabase.class,"birthdays")
                .allowMainThreadQueries()
                .build();

        List<Person> persons = db.personDao().allPersons();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PersonAdapter(persons);
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View view){
        Log.d("myapp","onClick");
        Intent intent = new Intent(this,BirthdayInsertion.class);
        startActivity(intent);
    }
}
