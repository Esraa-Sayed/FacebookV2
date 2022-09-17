package com.esraa.rxjavafacebookv2.data;

import com.esraa.rxjavafacebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    //public Call<List<PostModel>> getPosts();
    //convert from call to rxJava
    public Single<List<PostModel>> getPosts();
}
