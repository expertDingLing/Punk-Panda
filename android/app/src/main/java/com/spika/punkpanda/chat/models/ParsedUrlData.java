package com.spika.punkpanda.chat.models;

import com.spika.punkpanda.chat.base.BaseModel;

/**
 * Created by ling on 17.07.15..
 */
public class ParsedUrlData extends BaseModel {

    public String title;
    public String desc;
    public String host;
    public String url;
    public String imageUrl;
    public String siteName;

    @Override
    public String toString() {
        return "ParsedUrlData{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", siteName='" + siteName + '\'' +
                '}';
    }
}
