package com.grntea.ygocard.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class card implements Parcelable {
    private int id;
    private String name;
    private String type;
    private String desc;
    private int atk;
    private int def;
    private int level;
    private String race;
    private String attribute;
    @SerializedName("card_images")
    private List<cardImage> cardImageList;


    public card() { }

    protected card(Parcel in) {
        id = in.readInt();
        name = in.readString();
        type = in.readString();
        desc = in.readString();
        atk = in.readInt();
        def = in.readInt();
        level = in.readInt();
        race = in.readString();
        attribute = in.readString();
    }

    public static final Creator<card> CREATOR = new Creator<card>() {
        @Override
        public card createFromParcel(Parcel in) {
            return new card(in);
        }

        @Override
        public card[] newArray(int size) {
            return new card[size];
        }
    };

    public List<cardImage> getCardImageList() {
        return cardImageList;
    }

    public void setCardImageList(List<cardImage> cardImageList) {
        this.cardImageList = cardImageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(desc);
        dest.writeInt(atk);
        dest.writeInt(def);
        dest.writeInt(level);
        dest.writeString(race);
        dest.writeString(attribute);
    }
}
