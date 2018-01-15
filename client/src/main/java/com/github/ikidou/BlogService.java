package com.github.ikidou;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface BlogService {
    //@Part 是直接替换path中对应的key的值

    @GET("blog/{id}")
    Call<ResponseBody> getBlog(@Path("id") int id);

    @HTTP(method = "GET", path = "blog/{id}", hasBody = false)
    Call<ResponseBody> getBlog2(@Path("id") int id);


    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> formUrlEncoded1(@Field("username") String name, @Field("age") int age);

    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> formUrlEncoded2(@FieldMap Map<String, Object> map);


    @POST("/form")
    @Multipart
    Call<ResponseBody> fileUpload1(@Part("name") RequestBody name, @Part("age") RequestBody age, @Part MultipartBody.Part file);

    @POST("/form")
    @Multipart
    Call<ResponseBody> fileUpload2(@PartMap Map<String, RequestBody> args, @Part MultipartBody.Part file);

    @POST("/form")
    @Multipart
    Call<ResponseBody> fileUpload3(@PartMap Map<String, RequestBody> args);
}
