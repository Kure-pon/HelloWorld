package com.grntea.ygocard.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Deck")
public class Deck {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private card card;
    @Ignore
    public Deck() {
    }

    public Deck(card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.grntea.ygocard.Models.card getCard() {
        return card;
    }

    public void setCard(com.grntea.ygocard.Models.card card) {
        this.card = card;
    }
}
