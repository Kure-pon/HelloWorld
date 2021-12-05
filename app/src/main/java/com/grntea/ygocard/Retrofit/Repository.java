package com.grntea.ygocard.Retrofit;

import androidx.lifecycle.LiveData;

import com.grntea.ygocard.DB.Dao;
import com.grntea.ygocard.Models.Deck;
import com.grntea.ygocard.Models.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class Repository {
    private final Api api;
    private final Dao dao;

    @Inject
    public Repository(Api api, Dao dao) {
        this.api = api;
        this.dao = dao;
    }

    public Single<data> getData() {
        return api.getAllData();
    }

    public void saveData(Deck f) {
        dao.saveData(f);
    }

    public void DeleteData(int id) {
        dao.DeleteData(id);
    }

    public LiveData<List<Deck>> getDeck() {
        return dao.getDeck();
    }
}
