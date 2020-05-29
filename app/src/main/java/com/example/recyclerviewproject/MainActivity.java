package com.example.recyclerviewproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    int count = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView thumbnailRecyclerView =  findViewById(R.id.rv_thumbnail);
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),width/180);
        thumbnailRecyclerView.setLayoutManager(gridLayoutManager);
        thumbnailRecyclerView.setHasFixedSize(true);
        ThumbnailAdapter mAdapter = new ThumbnailAdapter(count);
        mAdapter.setOnItemClickListener(new ThumbnailAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(MainActivity.this, "Position "+position, Toast.LENGTH_SHORT).show();
            }
        });
        thumbnailRecyclerView.setAdapter(mAdapter);
    }

}

