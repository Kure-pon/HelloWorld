package com.grntea.ygocard.Models;

import android.annotation.SuppressLint;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.grntea.ygocard.Retrofit.Repository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ModelView extends ViewModel {
    private final Repository repository;

    private LiveData<List<Deck>> Decklist = null;

    public LiveData<List<Deck>> getDeckList() {
        return Decklist;
    }

    private MutableLiveData<List<card>> cardMutableLiveData = new MutableLiveData<List<card>>();

    public LiveData<List<card>> getCardMutableLiveData() {
        if (cardMutableLiveData == null)
            cardMutableLiveData = new MutableLiveData<>();
        return cardMutableLiveData;
    }

    @ViewModelInject
    public ModelView(Repository repositoryRet) {
        this.repository = repositoryRet;
    }

    @SuppressLint("CheckResult")
    public void getData() {
        repository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> cardMutableLiveData.setValue(data.getCards()),
                        Throwable::printStackTrace);
    }

    public void getFav() {
        Decklist = repository.getDeck();
    }

    public void SaveData(Deck f) {
        repository.saveData(f);
    }

    public void DeleteData(int id) {
        repository.DeleteData(id);
    }
}
