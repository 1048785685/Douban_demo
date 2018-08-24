package com.soully.doudemo;

import com.soully.doudemo.Api.Hot.HotMovie;
import com.soully.doudemo.Api.Hot.UsBox.UxBox;

import retrofit2.http.GET;
import rx.Observable;

public interface NetService {
    @GET("/v2/movie/us_box")
    Observable<UxBox> getHotMovie();

    @GET("/v2/movie/in_theaters")
    Observable<HotMovie> getInTheaters ();

    @GET("/v2/movie/coming_soon")
    Observable<HotMovie> getComingSoon();

    @GET("/v2/movie/top250")
    Observable<HotMovie> getTop250();
}
