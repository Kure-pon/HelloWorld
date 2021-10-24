package com.grntea.ygocard.DB;

import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DbModule {

    @Provides
    @Singleton
    public static DoaDB ProvideDb(Application application){
        return Room.databaseBuilder(
                application
                , DoaDB.class
                ,"DoaDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }


    @Provides
    @Singleton
    public static Doa ProvideDao(DoaDB doaDB){
        return doaDB.doa();
    }
}
