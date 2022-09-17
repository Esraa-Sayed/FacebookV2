package com.esraa.rxjavafacebookv2.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.esraa.rxjavafacebookv2.pojo.PostModel;

import java.util.List;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    public  void getPosts(){

    }
}
