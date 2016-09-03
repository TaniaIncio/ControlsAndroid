package com.tincio.controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tincio.controls.adapter.AdapterRecyclerGridLayout;

import java.util.Arrays;

public class GridLayoutActivity extends AppCompatActivity {

    RecyclerView recImageMovie;
    private GridLayoutManager gridLayoutManager;
    AdapterRecyclerGridLayout adapterRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        recImageMovie = (RecyclerView) findViewById(R.id.activity_gridlayout_recycler);
        gridLayoutManager = new GridLayoutManager(GridLayoutActivity.this, 2);
        recImageMovie.setHasFixedSize(true);
        recImageMovie.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String[] array = {"Interestelar1","Interestelar2","Interestelar3","Interestelar4",
                "Interestelar1","Interestelar2","Interestelar3","Interestelar4",
                "Interestelar1","Interestelar2","Interestelar3","Interestelar4"};
        adapterRecycler = new AdapterRecyclerGridLayout(Arrays.asList(array));
        recImageMovie.setAdapter(adapterRecycler);
    }
}
