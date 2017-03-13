package com.android.reading.view.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.android.reading.R;
import com.android.reading.databinding.ActivityHomeBinding;
import com.android.reading.navigation.HomeNavigator;
import com.android.reading.presenter.NewsPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.adapter.NewsCategoryPageAdapter;
import com.android.reading.view.ui.base.BaseActivity;

import java.util.List;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseView {

    private ActivityHomeBinding mBinding;
    private HomeNavigator mHomeNavigator;

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
        setSupportActionBar(mBinding.include.toolbar);
        setTitle(R.string.nav_news);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mBinding.drawerLayout, mBinding.include.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mBinding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        mHomeNavigator = new HomeNavigator();
        NewsPresenterImpl presenter = new NewsPresenterImpl(Constants.NEWS_CATEGORY, this);
        presenter.showNewsCategoryView();
    }

    @Override
    public void onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_joke) {
            mHomeNavigator.navigatorToJoke(this);
        } else if (id == R.id.nav_featured) {
            mHomeNavigator.navigatorToFeatured(this);
        } else if (id == R.id.nav_collection) {
            mHomeNavigator.navigatorToCollection(this);
        } else if (id == R.id.nav_colorful) {
            mHomeNavigator.navigatorToSkin(this);
        }

        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void showData(List<?> data) {
        String[] categoryList = getResources().getStringArray(R.array.news_category);
        mBinding.include.viewPager.setAdapter(new NewsCategoryPageAdapter
                (getSupportFragmentManager(), (List<Fragment>) data, categoryList));
        mBinding.include.viewPager.setOffscreenPageLimit(categoryList.length - 1);
        mBinding.include.tabLayout.setupWithViewPager(mBinding.include.viewPager);
    }

    @Override
    public void showMsg(Object msg) {

    }
}
