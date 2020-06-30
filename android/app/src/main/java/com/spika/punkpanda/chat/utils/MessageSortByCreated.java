package com.spika.punkpanda.chat.utils;

import com.spika.punkpanda.chat.models.Message;

import java.util.Comparator;

/**
 * Created by ling on 10.08.15..
 */
public class MessageSortByCreated implements Comparator<Message>{

    @Override
    public int compare(Message lhs, Message rhs) {

        long postedTime1 = lhs.created;
        long postedTime2 = rhs.created;

        if (postedTime1 > postedTime2) {
            return 1;
        } else if (postedTime1 < postedTime2) {
            return -1;
        }

        return 0;
    }

}
