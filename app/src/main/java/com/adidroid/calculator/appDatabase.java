package com.adidroid.calculator;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1 ,exportSchema=false)
public abstract class appDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
