package com.example.scuwsg.drawerandtab;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        String[] titles = getResources().getStringArray(R.array.titles);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        NavigationView navView = (NavigationView) findViewById(R.id.navigation_view);
        LinearLayout navHeader = (LinearLayout) navView.getHeaderView(0);
        ImageView avatar = (ImageView) navHeader.findViewById(R.id.avatar);
        setCircleImageview(avatar);

    }


    @Override
    public void onBackPressed() {
        //如果drawerlayout没有关闭，则点击返回键应首先将其关闭
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_call:
                break;
            case R.id.nav_camera:
                break;
            default:
                //实现相应菜单项的功能
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        return true;
    }

    //设置图片为圆形图片
    private void setCircleImageview(ImageView imageview) {
        Resources res = getResources();
        Bitmap src = BitmapFactory.decodeResource(res, R.drawable.yakumo);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(res, src);
        roundedBitmapDrawable.setCornerRadius(Math.min(src.getHeight(), src.getWidth()) / 2.0f);
        imageview.setImageDrawable(roundedBitmapDrawable);
    }
}
