package com.spika.punkpanda.chat.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.spika.punkpanda.chat.base.BaseModel;

/**
 * Created by ling on 22.07.15..
 */
public class UploadFileResult extends BaseModel implements Parcelable{

    public FileModel data;

    public UploadFileResult() {
    }

    @Override
    public String toString() {
        return "UploadFileResult{" +
                "data=" + data +
                '}';
    }

    protected UploadFileResult(Parcel in) {
        data = (FileModel) in.readValue(FileModel.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(data);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UploadFileResult> CREATOR = new Parcelable.Creator<UploadFileResult>() {
        @Override
        public UploadFileResult createFromParcel(Parcel in) {
            return new UploadFileResult(in);
        }

        @Override
        public UploadFileResult[] newArray(int size) {
            return new UploadFileResult[size];
        }
    };

}
