package com.example.lotusflareadmin.myapplication.main.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.lotusflareadmin.myapplication.R;
import com.example.lotusflareadmin.myapplication.main.di.DiComponent;
import com.example.lotusflareadmin.myapplication.main.presenter.BasePresenter;

import static com.example.lotusflareadmin.myapplication.main.di.DaggerDiComponent.*;

/**
 * Created by Ana Nedic.
 */
public class MainActivity extends BaseActivity implements Screen {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(getInitializedToolbar());

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Important: injection dependencies!
        DiComponent component = builder().build();
        component.inject(this);
        presenter.test();
    }

    @Override
    public void displayTasks(int number) {
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(number);
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    @Override
    public Screen getScreen() {
        return this;
    }

    @NonNull
    @Override
    public BasePresenter<Screen> getPresenter() {
        return this.presenter;
    }


    private Toolbar getInitializedToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        return toolbar;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int resId = item.getItemId();
        if (resId == R.id.language) {
            presenter.test();
        } else if (resId == R.id.about) {
            DialogFragment df = new ShowAboutDialog();
            df.show(getFragmentManager(),"dialog");
        }
        return true;
    }
}
