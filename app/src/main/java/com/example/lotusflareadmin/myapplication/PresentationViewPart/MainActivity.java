package com.example.lotusflareadmin.myapplication.PresentationViewPart;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lotusflareadmin.myapplication.R;

/**
 * Created by Ana Nedic.
 */
public class MainActivity extends AppCompatActivity implements Screen {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(200);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        setSupportActionBar(getInitializedToolbar());
    }

    private Toolbar getInitializedToolbar() {
        toolbar = findViewById(R.id.toolbar);

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
            Toast.makeText(getApplicationContext(),
                    "You selected language.",
                    Toast.LENGTH_LONG
                    ).show();
        } else if (resId == R.id.about) {
            DialogFragment df = new ShowAboutDialog();
            df.show(getFragmentManager(),"dialog");
        }
        return true;
    }
}
