package com.project2.mini.yunkyun.miniproject2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.project2.mini.yunkyun.miniproject2.R.id.rv;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private boolean layoutFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setToolbar();
        setDrawer();
        setRecyclerView();

        initContents();
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);;
        setSupportActionBar(toolbar);
    }

    private void setDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initContents() {
        String[] titleList = getResources().getStringArray(R.array.store_name_array);
        String[] descList = getResources().getStringArray(R.array.store_desc_array);
        int[] popularityList = getResources().getIntArray(R.array.store_popularity_array);
        int[] recentList = getResources().getIntArray(R.array.store_recent_array);
        int[] distanceList = getResources().getIntArray(R.array.store_distance_array);

        ArrayList<StoreItem> items = new ArrayList<>();
        for(int i = 0; i < titleList.length; i++){
            StoreItem item = new StoreItem(titleList[i], descList[i], popularityList[i], recentList[i], distanceList[i]);
            items.add(item);
        }

        adapter.setItemList(items);
        adapter.notifyDataSetChanged();
    }

    private void changeLayoutManager() {
        RecyclerView.LayoutManager layoutManager;
        if(layoutFlag) {
            layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(this);
        }
        layoutFlag = !layoutFlag;
        recyclerView.setLayoutManager(layoutManager);
    }


    @OnClick({R.id.btn_distance, R.id.btn_popularity, R.id.btn_recent, R.id.btn_change_layout})
    void OnSortButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_distance:
                adapter.sortItemList(RecyclerAdapter.SORT_BY_DISTANCE);
                break;
            case R.id.btn_popularity:
                adapter.sortItemList(RecyclerAdapter.SORT_BY_POPULARITY);
                break;
            case R.id.btn_recent:
                adapter.sortItemList(RecyclerAdapter.SORT_BY_RECENT);
                break;
            case R.id.btn_change_layout:
                changeLayoutManager();
                break;
            default:
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.nav_camera:
                Toast.makeText(this, "카메라", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(this, "카메라를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "카메라를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
