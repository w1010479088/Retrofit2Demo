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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * [Retrofit注解详解 之 FormUrlEncoded/Field/FieldMap注解]源码
 */
public class Example05 {

    public static void main(String[] args) {
        RetrofitServiceProvider
                .getService()
                .urlAndQuery("headers", false)
                .enqueue(RetrofitServiceProvider.getCallBack());
    }
}
