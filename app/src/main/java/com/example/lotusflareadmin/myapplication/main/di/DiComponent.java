package com.example.lotusflareadmin.myapplication.main.di;

import com.example.lotusflareadmin.myapplication.main.presenter.BasePresenter;
import com.example.lotusflareadmin.myapplication.main.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ana Nedic.
 */
@Singleton
@Component(modules = {DiModule.class})
public interface DiComponent {
    BasePresenter providePresenter();

    /*Important: injector will inject all the dependencies in the created object,
    without having to mention each dependency. */
    void inject(MainActivity activity);
}
