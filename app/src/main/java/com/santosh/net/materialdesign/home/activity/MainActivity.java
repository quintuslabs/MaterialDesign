package com.santosh.net.materialdesign.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.santosh.net.materialdesign.R;
import com.santosh.net.materialdesign.home.adapter.ParentAdapter;
import com.santosh.net.materialdesign.home.model.Child;
import com.santosh.net.materialdesign.home.model.Parent;
import com.santosh.net.materialdesign.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Parent> parentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ParentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.darkenStatusBar(this, R.color.colorPrimary);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.main_rv);

        mAdapter = new ParentAdapter(parentList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareParentData();
    }

    private void prepareParentData() {
        List<Child> animationList = new ArrayList<>();
        animationList.add(new Child(101, "Basic Animation"));
        animationList.add(new Child(102, "View Animation"));
        animationList.add(new Child(103, "Layout Animation"));
        parentList.add(new Parent(100, "animation", animationList));

        List<Child> buttonsList = new ArrayList<>();
        buttonsList.add(new Child(201, "Basic"));
        buttonsList.add(new Child(202, "Bution Utility"));
        buttonsList.add(new Child(203, "Fab Button"));
        buttonsList.add(new Child(204, "Fab more"));
        buttonsList.add(new Child(205, "Fab With Text"));
        parentList.add(new Parent(200, "Buttons", buttonsList));

        mAdapter.notifyDataSetChanged();
    }

   /* public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("menu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }*/

}
