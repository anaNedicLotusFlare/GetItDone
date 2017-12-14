package com.example.lotusflareadmin.myapplication.main.di;

import com.example.lotusflareadmin.myapplication.main.presenter.BasePresenter;
import com.example.lotusflareadmin.myapplication.main.presenter.TaskPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ana Nedic.
 */

@Module
public class DiModule {

    @Provides @Singleton
    BasePresenter providePresenter() {
        return new TaskPresenter();
    }
}
