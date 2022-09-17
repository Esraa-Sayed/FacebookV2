package com.esraa.rxjavafacebookv2.data;

import com.esraa.rxjavafacebookv2.pojo.PostModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("post")
    public Call<PostModel> getPosts();
}
