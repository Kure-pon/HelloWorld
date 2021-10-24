package com.grntea.ygocard.DB;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.grntea.ygocard.Models.card;

public class Converters {

    @TypeConverter
    public String FromCardToString(card card) {
        return new Gson().toJson(card);
    }

    @TypeConverter
    public card FromStringTocard(String json) {
        return new Gson().fromJson(json, card.class);
    }

}
