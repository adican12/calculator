package com.adidroid.calculator;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person ORDER BY birthday ASC")
    List<Person> allPersons();

    @Insert
    void insertAll(Person... persons);

    @Query("DELETE FROM person")
    void deleteAll();
}
