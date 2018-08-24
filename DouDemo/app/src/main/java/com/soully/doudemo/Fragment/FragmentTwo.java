package com.soully.doudemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soully.doudemo.Adapter.RecyclerTwoAdapter;
import com.soully.doudemo.Api.Hot.HotMovie;
import com.soully.doudemo.Api.Hot.UsBox.UxBox;
import com.soully.doudemo.Bean.TwoBean;
import com.soully.doudemo.NetService;
import com.soully.doudemo.R;
import com.soully.doudemo.two;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Soully on 2017/3/29.
 */

public class FragmentTwo extends Fragment{
    private List<TwoBean> twoBeanList = new ArrayList<>();
    @BindView(R.id.recycler_two)RecyclerView recyclerView;
    private RecyclerTwoAdapter adapter;
    private Retrofit retrofit;
    private NetService service;
    String[] TopTitle = new String[30];
    String[] TopImage = new String[30];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);

        ButterKnife.bind(this, view);
        recyclerView.setVisibility(View.GONE);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(NetService.class);
//        Rxinit();
        service.getTop250()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovie>() {
                    @Override
                    public void onCompleted() {
                        Log.d("getTop250","Finish");
                        update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getTop250","Error");
                        Rxinit();
//                        update();
                    }

                    @Override
                    public void onNext(HotMovie hotMovie) {
                        for (int i=0;i<hotMovie.getCount();i++){
                            TopTitle[i] = hotMovie.getSubjects().get(i).getTitle();
                            TopImage[i] = hotMovie.getSubjects().get(i).getImages().getLarge();
                        }
                    }
                });
        LinearLayoutManager mLayoutManager = new GridLayoutManager(this.getContext(),3);
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    private void Rxinit() {
        service.getTop250()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovie>() {
                    @Override
                    public void onCompleted() {
                        Log.d("getTop250","Finish");
                     update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("getTop250","Error");
                        Rxinit();
//                        update();
                    }

                    @Override
                    public void onNext(HotMovie hotMovie) {
                        for (int i=0;i<hotMovie.getCount();i++){
                            TopTitle[i] = hotMovie.getSubjects().get(i).getTitle();
                            TopImage[i] = hotMovie.getSubjects().get(i).getImages().getLarge();
                        }
                    }
                });
    }
    public void update(){
        for (int i=0;i<20;i++){
            TwoBean bean = new TwoBean();
            bean.setImage(TopImage[i]);
            bean.setName(TopTitle[i]);
            twoBeanList.add(bean);
        }
        adapter = new RecyclerTwoAdapter(this.getContext(),twoBeanList);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setOnRecycleViewListener(new RecyclerTwoAdapter.OnRecycleViewListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(view.getContext(),two.class);
                startActivity(intent);
            }
        });
    }
}