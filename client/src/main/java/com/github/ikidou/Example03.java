/*
 * Copyright 2016 ikidou
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ikidou;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * [Retrofit注解详解 之 FormUrlEncoded/Field/FieldMap/Multipart/Part/PartMap注解]源码
 */
public class Example03 {

    public static void main(String[] args) {
        BlogService blogService = RetrofitServiceProvider.getService();
        MediaType textType = MediaType.parse("text/plain");
        RequestBody name = RequestBody.create(textType, "怪盗kidou");
        RequestBody age = RequestBody.create(textType, "24");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "这里是模拟文件的内容");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);

        test1(blogService);
        test2(blogService);
        test3(blogService, filePart, name, age, file);
        test4(blogService, filePart, name, age, file);
        test5(blogService, filePart, name, age, file);
    }

    private static void test1(BlogService blogService) {
        blogService
                .formUrlEncoded1("怪盗kidou", 24)
                .enqueue(RetrofitServiceProvider.getCallBack());
    }

    private static void test2(BlogService blogService) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "怪盗kidou");
        map.put("age", 24);

        blogService
                .formUrlEncoded2(map)
                .enqueue(RetrofitServiceProvider.getCallBack());
    }

    private static void test3(BlogService blogService, MultipartBody.Part filePart, RequestBody... body) {
        blogService
                .fileUpload1(body[0], body[1], filePart)
                .enqueue(RetrofitServiceProvider.getCallBack());
    }

    private static void test4(BlogService blogService, MultipartBody.Part filePart, RequestBody... body) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("name", body[0]);
        map.put("age", body[1]);

        blogService
                .fileUpload2(map, filePart)
                .enqueue(RetrofitServiceProvider.getCallBack()); //单独处理文件
    }

    private static void test5(BlogService blogService, MultipartBody.Part filePart, RequestBody... body) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put("name", body[0]);
        map.put("age", body[1]);
        map.put("file\"; filename=\"test.txt", body[2]);

        blogService
                .fileUpload3(map)
                .enqueue(RetrofitServiceProvider.getCallBack());
    }
}
