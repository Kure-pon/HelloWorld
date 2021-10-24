package com.grntea.ygocard.Retrofit;

import com.grntea.ygocard.Models.data;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("cardinfo.php")
    Single<data> getAllData();
}
