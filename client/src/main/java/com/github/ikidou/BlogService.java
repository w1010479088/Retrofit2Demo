package com.github.ikidou;

import com.github.ikidou.entity.Blog;
import com.github.ikidou.entity.Result;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.List;
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

    @GET("/headers?showAll=true")
    @Headers({"CustomHeader1: customHeaderValue1", "CustomHeader2: customHeaderValue2"})
    Call<ResponseBody> header(@Header("CustomHeader3") String customHeaderValue3);


    /**
     * 当GET、POST...HTTP等方法中没有设置Url时，则必须使用 {@link Url}提供
     * 对于Query和QueryMap，如果不是String（或Map的第二个泛型参数不是String）时
     * 会被默认会调用toString转换成String类型
     * Url支持的类型有 okhttp3.HttpUrl, String, java.net.URI, android.net.Uri
     * {@link retrofit2.http.QueryMap} 用法和{@link retrofit2.http.FieldMap} 用法一样，不再说明
     */
    @GET
    Call<ResponseBody> urlAndQuery(@Url String url, @Query("showAll") boolean showAll);

    @GET("blog/{id}")
    Call<Result<Blog>> getBlog3(@Path("id") int id);

    @POST("blog")
    Call<Result<Blog>> createBlog(@Body Blog blog);

    @GET("/blog")
    Observable<Result<List<Blog>>> getBlogs(@Query("page") int page);

    @GET("blog/{id}")
    Observable<Result<Blog>> getBlogObservable(@Path("id") int id);
}
