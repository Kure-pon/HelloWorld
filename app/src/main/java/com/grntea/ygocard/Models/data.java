package com.grntea.ygocard.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class data {
    @SerializedName("data")
    private List<card> cards = null;

    public data() {
    }

    public List<card> getCards() {
        return cards;
    }

    public void setCards(List<card> cards) {
        this.cards = cards;
    }
}
