package com.grntea.ygocard.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.grntea.ygocard.Models.Deck;

@Database(entities = {Deck.class}, version = 5)
@TypeConverters(Converters.class)
public abstract class DaoDB extends RoomDatabase {
    public abstract Dao doa();
}
