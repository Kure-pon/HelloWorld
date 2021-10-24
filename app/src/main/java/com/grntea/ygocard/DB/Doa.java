package com.grntea.ygocard.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.grntea.ygocard.Models.Deck;

import java.util.List;

@Dao
public interface Doa {

    @Insert
    void saveData(Deck f);

    @Query("Delete from fav where id = :id")
    void DeleteData(int id);

    @Query("Select * from fav")
    LiveData<List<Deck>> getDeck();


}
