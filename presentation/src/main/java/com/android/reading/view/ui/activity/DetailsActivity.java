package com.android.reading.view.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.reading.R;
import com.android.reading.databinding.ActivityDetailsBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.StatusModel;
import com.android.reading.presenter.DetailsPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.base.BaseActivity;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/9 5:51.
 * LoveReading.
 */

public class DetailsActivity extends BaseActivity implements ClickHandler, BaseView {

    private ActivityDetailsBinding mBinding;
    private Object mObject;
    private DetailsPresenterImpl mPresenter;
    private boolean isCollection = false;

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(DetailsActivity.this, R.layout.activity_details);
        mBinding.setClickHandler(this);
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        String type = intent.getStringExtra(Constants.BUNDLE_TYPE);
        setTitle(getString(R.string.activity_details, type));

        mObject = intent.getParcelableExtra(Constants.BUNDLE_MODEL);
        mPresenter = new DetailsPresenterImpl(this, this);
        mPresenter.onQuery(mObject);

        String url = intent.getStringExtra(Constants.BUNDLE_URL);
        initWebView(url);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initWebView(String url) {
        WebSettings webSettings = mBinding.detailsWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        mBinding.detailsWebView.loadUrl(url);
        WebViewClient webViewClient = new WebViewClient() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        mBinding.detailsWebView.setWebViewClient(webViewClient);
    }

    private void isCollection() {
        isCollection = true;
        mBinding.collection.setBackgroundResource(R.drawable.ic_collection_p);
    }

    private void notCollection() {
        isCollection = false;
        mBinding.collection.setBackgroundResource(R.drawable.ic_collection_n);
    }

    @Override
    public void onClick(Object o) {
        if (!isCollection) {
            mPresenter.onInsert(mObject);
        } else {
            mPresenter.onDelete(mObject);
        }
    }

    @Override
    public void onLongClick() {
    }

    @Override
    public void showData(List<?> data) {
    }

    @Override
    public void showMsg(Object msg) {
        StatusModel statusModel = (StatusModel) msg;
        if (statusModel.isStatus()) {
            if (isCollection) {
                notCollection();
            } else {
                isCollection();
            }
        }

        if (Utils.isEmpty(statusModel.getMsg())) {

        }
    }

    @Override
    public void showEmptyView(String msg) {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void dismissLoadingView() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.getKeyCode() && mBinding.detailsWebView.canGoBack()) {
            mBinding.detailsWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.detailsWebView.destroy();
    }
}
