package com.tutorials.hp.recyclerfilter.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.tutorials.hp.recyclerfilter.R;
import com.tutorials.hp.recyclerfilter.mFilter.FilterHelper;

import java.util.ArrayList;

/**
 * Created by Oclemy on 9/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {

    Context c;
    ArrayList<String> spacecrafts;
    ArrayList<String> currentList;

    public MyAdapter(Context c, ArrayList<String> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
        this.currentList=spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nametxt.setText(spacecrafts.get(position));

    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }

    @Override
    public Filter getFilter() {
        return FilterHelper.newInstance(currentList,this);
    }

    public void setSpacecrafts(ArrayList<String> filteredSpacecrafts)
    {
        this.spacecrafts=filteredSpacecrafts;
    }
}
