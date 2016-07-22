package com.tincio.controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tincio.controls.adapter.AdapterRecycler;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView.LayoutManager mManager;
    RecyclerView myRecycler;
    AdapterRecycler mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        myRecycler = (RecyclerView)findViewById(R.id.recycler_uno);
        //
        mManager = new LinearLayoutManager(getApplicationContext() , LinearLayoutManager.VERTICAL, false);
        myRecycler.setLayoutManager(mManager);
        String[] array = getResources().getStringArray(R.array.array_elements_recycler);
        mAdapter = new AdapterRecycler(array);
        myRecycler.setAdapter(mAdapter);
    }
}
