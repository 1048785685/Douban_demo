package com.soully.doudemo;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.soully.doudemo.Adapter.ViewpagerAdapter;
import com.soully.doudemo.Fragment.FragmentOne;
import com.soully.doudemo.Fragment.FragmentTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.draw_layout)DrawerLayout draw_layout;
    @BindView(R.id.tab_top)TabLayout tabLayout;
    @BindView(R.id.myViewPager)ViewPager mViewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        //toolbar.setBackgroundColor(Color.YELLOW);
        /*
       ActionBarDrawerToggle实现在ToolBar侧滑包括左上角的Home键
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, draw_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        Log.d("XXXX", String.valueOf(toggle));
        draw_layout.setDrawerListener(toggle);
        Log.d("XXXX", String.valueOf(draw_layout));
        toggle.syncState();
        getSupportActionBar().setTitle("");

        if (mViewpager!=null){
            setUpViewPager(mViewpager);
        }
        tabLayout.setupWithViewPager(mViewpager);


    }

    @Override
    public void onBackPressed() {
        if (draw_layout.isDrawerOpen(GravityCompat.START)) {
            draw_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void setUpViewPager(ViewPager viewPager){
        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new FragmentOne(),"首页");
        adapter.addFragments(new FragmentTwo(),"Top250");
        viewPager.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
