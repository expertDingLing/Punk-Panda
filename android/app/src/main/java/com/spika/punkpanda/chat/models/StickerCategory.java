package com.spika.punkpanda.chat.models;

import com.spika.punkpanda.chat.base.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ling on 17.07.15..
 */
public class StickerCategory extends BaseModel implements Serializable{

    public String mainPic;
    public List<Sticker> list;

    @Override
    public String toString() {
        return "StickerCategory{" +
                "mainPic='" + mainPic + '\'' +
                ", list=" + list +
                '}';
    }
}
