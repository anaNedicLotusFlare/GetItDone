/*
 * Copyright (C) 2017 LotusFlare
 * All Rights Reserved.
 * Unauthorized copying and distribution of this file, via any medium is strictly prohibited.
 */

package com.example.lotusflareadmin.myapplication.main.presenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by aleksaboskov on 11/2/17.
 * A base class for all presenters.
 * Contains logic for detaching the view, so that if view is destroyed
 * presenter does not use it any more!
 *
 * @param <S> Type of this presenter's screen
 */

public abstract class BasePresenter<S> {

    private final CompositeDisposable compositeDisposable;

    BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void test() { //TODO: delete this
    }
    /**
     * Adds a disposable to the collection of all disposables contained in this presenter
     *
     * @param disposable The new disposable to be added
     */
    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    /**
     * Called when the view should detach and presenter should stop all operation.
     * <p>
     * Disposes all the stored disposables and removes them from the collection.
     */
    public void unsubscribe() {
        compositeDisposable.clear();
    }

    /**
     * Called when this presenter's screen is first shown.
     *
     * @param screen This presenter's screen
     */
    public abstract void onScreenShown(S screen);
}
