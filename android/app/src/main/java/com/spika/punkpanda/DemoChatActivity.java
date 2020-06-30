package com.spika.punkpanda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.spika.punkpanda.chat.ChatActivity;
import com.spika.punkpanda.chat.models.Config;
import com.spika.punkpanda.chat.models.User;
import com.spika.punkpanda.chat.utils.Const;

/**
 * Created by ling on 17.07.15..
 */
public class DemoChatActivity extends ChatActivity{

    public static void startChatActivity(Context context, User user){
        Intent intent = new Intent(context, DemoChatActivity.class);
        intent.putExtra(Const.Extras.USER, user);
        context.startActivity(intent);
    }

    public static void startChatActivityWithConfig(Context context, User user, Config config){
        Intent intent = new Intent(context, DemoChatActivity.class);
        intent.putExtra(Const.Extras.USER, user);
        intent.putExtra(Const.Extras.CONFIG, config);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        changeToolbarColor("#0000ff");
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
