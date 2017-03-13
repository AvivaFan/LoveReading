package com.android.reading.navigation;

import android.content.Context;
import android.content.Intent;

import com.android.reading.view.ui.activity.CollectionActivity;
import com.android.reading.view.ui.activity.FeaturedActivity;
import com.android.reading.view.ui.activity.JokeActivity;
import com.android.reading.view.ui.activity.SkinActivity;

/**
 * Created by Gu FanFan on 2017/3/10 22:56.
 * LoveReading.
 */

public class HomeNavigator {

    public void navigatorToJoke(Context context) {
        Intent intent = JokeActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigatorToFeatured(Context context) {
        Intent intent = FeaturedActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigatorToCollection(Context context) {
        Intent intent = CollectionActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigatorToSkin(Context context) {
        Intent intent = SkinActivity.getCallingIntent(context);
        context.startActivity(intent);
    }
}
