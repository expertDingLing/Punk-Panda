package com.spika.punkpanda.chat.api.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ling on 10.02.16..
 */
public interface CustomResponseListener<T> extends Callback<T>{

    @Override
    void onFailure(Call<T> call, Throwable t);

    @Override
    void onResponse(Call<T> call, Response<T> response);

    void onCustomFailed(Call<T> call, Response<T> response);

    void onCustomSuccess(Call<T> call, Response<T> response);

}
