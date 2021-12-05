package com.grntea.ygocard.Retrofit;

import com.grntea.ygocard.Models.data;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("cardinfo.php")
    Single<data> getAllData();

    @GET("cardinfo.php")
    Call<data> getQuery(
            @Query("fname") String fname
    );
}
