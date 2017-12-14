package com.example.lotusflareadmin.myapplication.main.view;

/**
 * Contains logic that will be invoked by Presenter when
 * e.g. data to be displayed is returned from use case.
 * Created by Ana Nedic.
 */

public interface Screen {
    //this is how view responds to a finished operation from  presenter
    void displayTasks(int number); //TODO: replace number with task list
 }
