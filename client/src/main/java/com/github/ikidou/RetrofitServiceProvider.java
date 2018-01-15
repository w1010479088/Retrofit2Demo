package com.github.ikidou;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

class RetrofitServiceProvider {
    static BlogService getService() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:4567/")
                .build()
                .create(BlogService.class);
    }

    static Callback<ResponseBody> getCallBack() {
        return new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.err.println("Message:" + t.getMessage());
            }
        };
    }
}
