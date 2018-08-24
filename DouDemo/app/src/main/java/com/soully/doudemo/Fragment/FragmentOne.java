package com.soully.doudemo.Fragment;

import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soully.doudemo.Adapter.RecyclerOneAdapter;
import com.soully.doudemo.Api.Hot.HotMovie;
import com.soully.doudemo.Api.Hot.UsBox.UxBox;
import com.soully.doudemo.BaseFragment;
import com.soully.doudemo.Bean.OneBean;
import com.soully.doudemo.Draw;
import com.soully.doudemo.NetService;
import com.soully.doudemo.R;
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
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Soully on 2017/3/29.
 */

public class FragmentOne extends BaseFragment {
    @BindView(R.id.recycler_one)RecyclerView mRecyclerView;
    @BindView(R.id.draw)Draw draw;
    private List<OneBean> oneBeanList = new ArrayList<>();
    private RecyclerOneAdapter recyclerOneAdapter;

    private int one = 0;
    private int two = 0;
    private int three = 0;
    String[] hotTitle = new String[20];
    String[] hotImage = new String[20];
    String[] RecentlyTitle = new String[20];
    String[] RecentlyImage = new String[20];
    String[] USTitle = new String[20];
    String[] USImage = new String[20];
    private Retrofit retrofit;
    private NetService service;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        ButterKnife.bind(this, view);

        mRecyclerView.setVisibility(View.GONE);
        setMyDraw(draw);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(NetService.class);

        RxInit();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
//        recyclerOneAdapter= new RecyclerOneAdapter(this.getContext(),oneBeanList);
//        mRecyclerView.setAdapter(recyclerOneAdapter);

        return view;
    }

    private void RxInit() {
        Hot();
        Coming();
        Us();
//        OneBean bean = new OneBean();
//        bean.setHot(hotTitle);
//        bean.setHotImage(hotImage);
//        bean.setRecentlyImage(RecentlyImage);
//        bean.setRecently(RecentlyTitle);
//        bean.setUsImage(USImage);
//        bean.setUs(USTitle);
//        oneBeanList.add(bean);
    }

    private void Us() {
        service.getHotMovie()
//                .compose(this.<UxBox>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UxBox>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Us","SecondFinish");
                        one = 1;
                        update();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Us","SecondError");
//                        one = 1;
//                        update();
                        Us();
                    }
                    @Override
                    public void onNext(UxBox uxBox) {
                        Log.d("Us", String.valueOf(uxBox));
                        for (int i =0;i<uxBox.getSubjects().size();i++)
                        {
                            USTitle[i]=uxBox.getSubjects().get(i).getSubject().getTitle();
                            USImage[i]=uxBox.getSubjects().get(i).getSubject().getImages().getLarge();
                        }
                        Log.d("Us","Us成功");
                        Log.d("Us",USImage[0]);
                        Log.d("Us",USImage[2]);
                        Log.d("Us",USImage[1]);
                    }
                });
    }
    public void Hot(){
        service.getInTheaters()
//                .compose(this.<HotMovie>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovie>() {
                    @Override
                    public void onCompleted() {
//                        recyclerOneAdapter.deleteData(0);
                     two = 1;
                     update();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Hot","Error");
//                        two = 1;
//                        update();
                        Hot();
                    }
                    @Override
                    public void onNext(HotMovie hotMovie) {
                        for (int i =0;i<hotMovie.getCount();i++)
                        {
                            hotTitle[i]=hotMovie.getSubjects().get(i).getTitle();
                            hotImage[i]=hotMovie.getSubjects().get(i).getImages().getLarge();
                        }
                        Log.d("Hot","Hot成功");
                        Log.d("Hot",hotImage[0]);
                        Log.d("Hot",hotImage[2]);
                        Log.d("Hot",hotImage[1]);
                    }
                });
    }
    public void Coming(){
        service.getComingSoon()
//                .compose(this.<HotMovie>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovie>() {
                    @Override
                    public void onCompleted() {

                        three = 1;
                      update();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Coming","SecondError");
//                        three = 1;
//                        update();
                        Coming();
                    }
                    @Override
                    public void onNext(HotMovie hotMovie) {
                        for (int i =0;i<hotMovie.getCount();i++)
                        {
                            RecentlyTitle[i]=hotMovie.getSubjects().get(i).getTitle();
                            RecentlyImage[i]=hotMovie.getSubjects().get(i).getImages().getLarge();
                        }
                        Log.d("Coming"," Recently成功");
                        Log.d("Coming", RecentlyImage[0]);
                        Log.d("Coming", RecentlyImage[2]);
                        Log.d("Coming", RecentlyImage[1]);
                    }
                });
    }
    public void update(){
        if (one==1&&two==1&&three==1){
            hideDraw();
            OneBean bean = new OneBean();
            bean.setHot(hotTitle);
            bean.setHotImage(hotImage);
            oneBeanList.add(0,bean);
            OneBean beanTwo = new OneBean();
            beanTwo.setRecentlyImage(RecentlyImage);
            beanTwo.setRecently(RecentlyTitle);
            oneBeanList.add(1,beanTwo);
            OneBean beanThree = new OneBean();
            beanThree.setUsImage(USImage);
            beanThree.setUs(USTitle);
            oneBeanList.add(2,beanThree);
            mRecyclerView.setVisibility(View.VISIBLE);
            recyclerOneAdapter= new RecyclerOneAdapter(this.getContext(),oneBeanList);
            mRecyclerView.setAdapter(recyclerOneAdapter);
        }
    }
}
