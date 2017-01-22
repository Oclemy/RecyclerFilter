package com.tutorials.hp.recyclerfilter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import com.tutorials.hp.recyclerfilter.mRecycler.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SearchView sv;
    MyAdapter adapter;
    String[] spacecrafts={
            "Casini","Challenger","Spirit","Opportunity","Curiosity","Enterprise","Pioneer","Spitzer","Voyager",
            "Rosetter","Columbia","Apollo 15","Apollo 17","Kepler"
    };
    ArrayList<String> spacecraftsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //RFERENCE VIEWS
        rv= (RecyclerView) findViewById(R.id.rv);
        sv= (SearchView) findViewById(R.id.sv);

        //RECYCLER PROPERTIES
        rv.setLayoutManager(new LinearLayoutManager(this));

        //FILL DATA
        spacecraftsList=getSpacecrafts();

        //ADAPTER
        adapter=new MyAdapter(this,spacecraftsList);
        rv.setAdapter(adapter);

       //EVENTS
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private ArrayList<String> getSpacecrafts()
    {

        for (String s: spacecrafts)
        {
            spacecraftsList.add(s);
        }
        return spacecraftsList;
    }


}
