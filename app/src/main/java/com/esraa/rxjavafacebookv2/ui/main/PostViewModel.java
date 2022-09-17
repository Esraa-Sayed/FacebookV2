package com.esraa.rxjavafacebookv2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esraa.rxjavafacebookv2.data.PostsClient;
import com.esraa.rxjavafacebookv2.pojo.PostModel;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    public  void getPosts(){

//        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
//            @Override
//            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
//              //  List<PostModel> respo = response.body();
//                if (response.body() != null)
//                    postsMutableLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<PostModel>> call, Throwable t) {
//
//            }
        //});

        //Convert from call to rxjava
        Single<List<PostModel>> observable  = PostsClient.getINSTANCE().getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
        Disposable disposable = observable.subscribe(o -> postsMutableLiveData.setValue(o), e->Log.e("TAG", "onError: "+ e.getMessage()));
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
