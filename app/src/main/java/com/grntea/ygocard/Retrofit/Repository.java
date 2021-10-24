package com.grntea.ygocard.Retrofit;

import androidx.lifecycle.LiveData;

import com.grntea.ygocard.DB.Doa;
import com.grntea.ygocard.Models.Deck;
import com.grntea.ygocard.Models.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class Repository {
    private final Api api;
    private final Doa doa;

    @Inject
    public Repository(Api api, Doa doa) {
        this.api = api;
        this.doa = doa;
    }

    public Single<data> getData() {
        return api.getAllData();
    }


    public void saveData(Deck f) {
        doa.saveData(f);
    }

    public void DeleteData(int id) {
        doa.DeleteData(id);
    }

    public LiveData<List<Deck>> getDeck() {
        return doa.getDeck();
    }
}
