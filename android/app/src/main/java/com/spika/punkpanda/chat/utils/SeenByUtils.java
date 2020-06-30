package com.spika.punkpanda.chat.utils;

import com.spika.punkpanda.chat.models.Message;
import com.spika.punkpanda.chat.models.SeenByModel;
import com.spika.punkpanda.chat.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ling on 17.07.15..
 */
public class SeenByUtils {

    /**
     * get unseen message from given message list
     * @param allMessages
     * @param myUser logged in user
     * @return list of ids for unseen messages
     */
    public static List<String> getUnSeenMessages(List<Message> allMessages, User myUser){

        List<String> unSeenMessagesIds = new ArrayList<>();

        for(Message item : allMessages){

            boolean seen = false;

            if(myUser.userID.equals(item.user.userID)){
                seen = true;
            }else{
                for(SeenByModel itemUser : item.seenBy){
                    if(itemUser.user.userID.equals(myUser.userID)){
                        seen = true;
                        continue;
                    }
                }
            }

            if(!seen){
                unSeenMessagesIds.add(item._id);
            }

        }

        return unSeenMessagesIds;

    }

}
