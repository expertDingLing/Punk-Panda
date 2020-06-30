package com.spika.punkpanda.chat.models;

import com.spika.punkpanda.chat.base.BaseModel;

import java.util.List;

/**
 * Created by ling on 22.07.15..
 */
public class GetStickersData extends BaseModel {

    public GetStickersInsideData data;

    public class GetStickersInsideData{
        public List<StickerCategory> stickers;
    }
}
