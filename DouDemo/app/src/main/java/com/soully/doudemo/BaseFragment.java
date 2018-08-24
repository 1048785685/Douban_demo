package com.soully.doudemo;

import android.view.View;

import com.trello.rxlifecycle.components.support.RxFragment;
import android.support.v4.app.Fragment;

/**
 * Created by Soully on 2017/4/8.
 */

public class BaseFragment extends Fragment {
    Draw draw;
    public void setMyDraw(Draw draw){
        this.draw = draw;
    }
    public void hideDraw() {
        draw.setVisibility(View.GONE);
    }
}
