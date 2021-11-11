package com.grntea.ygocard.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.grntea.ygocard.Models.Deck;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void saveData(Deck f);

    @Query("Delete from Deck where id = :id")
    void DeleteData(int id);

    @Query("Select * from Deck")
    LiveData<List<Deck>> getDeck();


}
