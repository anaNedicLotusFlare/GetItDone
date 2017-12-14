/*
 * Copyright (C) 2017 LotusFlare
 * All Rights Reserved.
 * Unauthorized copying and distribution of this file, via any medium is strictly prohibited.
 */

package com.example.lotusflareadmin.myapplication.main.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lotusflareadmin.myapplication.main.presenter.BasePresenter;

import javax.inject.Inject;

/**
 * Created by aleksaboskov on 11/7/17.
 * <p>
 * A base activity class that handles common functionality,
 * such as dependency injection.
 */

public abstract class BaseActivity<S extends Screen> extends AppCompatActivity {

    BasePresenter presenter;

    @Inject
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    // this is how an event from view is passed to the presenter
    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onScreenShown(getScreen());
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().unsubscribe();
    }

    /**
     * Gets this activity's presenter.
     */
    @NonNull
    protected abstract BasePresenter<S> getPresenter();

    /**
     * Gets this activity's screen interface.
     */
    @NonNull
    protected abstract S getScreen();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }
}
