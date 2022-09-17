package com.esraa.rxjavafacebookv2.data;

import com.esraa.rxjavafacebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static  PostsClient INSTANCE;

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE)
            INSTANCE = new PostsClient();
        return INSTANCE;
    }

    private PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);

    }
    public Single<List<PostModel>> getPosts(){
        return  postInterface.getPosts();
    }
}
