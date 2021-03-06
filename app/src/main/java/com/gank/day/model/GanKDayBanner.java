package com.gank.day.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.anbetter.beyond.model.IModel;

/**
 * Created by android_ls on 2016/12/29.
 */

public class GanKDayBanner implements IModel, Parcelable {

    public String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
    }

    public GanKDayBanner() {
    }

    protected GanKDayBanner(Parcel in) {
        this.url = in.readString();
    }

    public static final Creator<GanKDayBanner> CREATOR = new Creator<GanKDayBanner>() {
        @Override
        public GanKDayBanner createFromParcel(Parcel source) {
            return new GanKDayBanner(source);
        }

        @Override
        public GanKDayBanner[] newArray(int size) {
            return new GanKDayBanner[size];
        }
    };
}
