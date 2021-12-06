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

    @GET("cardinfo.php")
    Call<data> getatr(
            @Query("attribute") String atr
    );

    @GET("cardinfo.php")
    Call<data> getrace(
            @Query("race") String race
    );

    @GET("cardinfo.php")
    Call<data> gettype(
            @Query("type") String type
    );

    @GET("cardinfo.php")
    Call<data> getracespell(
            @Query("type") String type,
            @Query("race") String race
    );

    @GET("cardinfo.php")
    Call<data> queatr(
            @Query("fname") String fname,
            @Query("attribute") String atr
    );

    @GET("cardinfo.php")
    Call<data> querace(
            @Query("fname") String fname,
            @Query("race") String race
    );

    @GET("cardinfo.php")
    Call<data> quetype(
            @Query("fname") String fname,
            @Query("type") String type
    );

    @GET("cardinfo.php")
    Call<data> queracespell(
            @Query("fname") String fname,
            @Query("type") String type,
            @Query("race") String race
    );

}
