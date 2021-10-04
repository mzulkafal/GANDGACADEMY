package com.arexsofts.gandgacademy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.arexsofts.gandgacademy.MainActivity.swipeRefreshLayout;

public class MyWebViewClient extends WebViewClient {
    private static final String TAG = "MyWebViewClient";
    private Activity activity = null;

    public MyWebViewClient(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if (url.startsWith("https://gandgacademy.org"))
            return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        Log.d(TAG, "onPageFinished: " + url);
        swipeRefreshLayout.setRefreshing(false);
        MainActivity.webUrl = url;

    }


}
