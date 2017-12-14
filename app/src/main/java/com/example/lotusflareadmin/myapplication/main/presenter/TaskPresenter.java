package com.example.lotusflareadmin.myapplication.main.presenter;

import android.util.Log;

import com.example.lotusflareadmin.myapplication.main.view.Screen;

/**
 * Created by Ana Nedic.
 */

public class TaskPresenter extends BasePresenter<Screen> {

    @Override
    public void onScreenShown(Screen screen) {
        //TODO: invoke use case here, pass resulting task list instead of number
        screen.displayTasks(20);
    }

    public void test() {

        Log.d(TaskPresenter.class.getName(), "Dagger works!!!");
    }
}
