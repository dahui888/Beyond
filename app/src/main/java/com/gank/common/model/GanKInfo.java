package com.gank.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by android_ls on 2016/12/28.
 */

public class GanKInfo implements Parcelable {

    public String _id;
    public String createdAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public String used;
    public String who;
    public ArrayList<String> images;

    public GanKInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeString(this.createdAt);
        dest.writeString(this.desc);
        dest.writeString(this.publishedAt);
        dest.writeString(this.source);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeString(this.used);
        dest.writeString(this.who);
        dest.writeStringList(this.images);
    }

    protected GanKInfo(Parcel in) {
        this._id = in.readString();
        this.createdAt = in.readString();
        this.desc = in.readString();
        this.publishedAt = in.readString();
        this.source = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.used = in.readString();
        this.who = in.readString();
        this.images = in.createStringArrayList();
    }

    public static final Creator<GanKInfo> CREATOR = new Creator<GanKInfo>() {
        @Override
        public GanKInfo createFromParcel(Parcel source) {
            return new GanKInfo(source);
        }

        @Override
        public GanKInfo[] newArray(int size) {
            return new GanKInfo[size];
        }
    };
}
