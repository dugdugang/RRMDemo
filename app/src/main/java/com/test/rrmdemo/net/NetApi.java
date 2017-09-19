package com.test.rrmdemo.net;

import com.test.rrmdemo.entities.Book;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public interface NetApi {
    @GET("book/search")
    Observable<Book> getBook(@Query("q") String name,
                             @Query("tag") String tag,
                             @Query("start") String start,
                             @Query("count") int count);

    @GET("book/search")
    Call<Book> getBook(@QueryMap Map<String, String> map);

    @GET("group/{id}/users")
    Call<Book> getGroup(@Path("id") int groupId,
                        @Query("sort") String sort);

    @POST("book/search")
    Call<Book> getBook(@Body Book book);

    @FormUrlEncoded
    @POST("Api/User/login")
    Call<Book> updateUser(@Field("first_name") String first, @Field("last_name") String last);

    @GET("user")
    Call<Book> addHeader(@Header("Authorization") String authorization);

    @Headers("Cache-Control:max-age=640000")
    Call<Book> getUser();

    @Headers({"Accept:application/vnd.v3.full+json", "User-Agent:Retrofit-Sample-App"})
    @GET("user")
    Call<Book> getUsers();



}
