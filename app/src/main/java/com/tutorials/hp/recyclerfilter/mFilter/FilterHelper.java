package com.tutorials.hp.recyclerfilter.mFilter;

import android.widget.Filter;

import com.tutorials.hp.recyclerfilter.mRecycler.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Oclemy on 9/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class FilterHelper extends Filter {

    static ArrayList<String> currentList;
    static MyAdapter adapter;


    public static FilterHelper newInstance(ArrayList<String> currentList, MyAdapter adapter) {
        FilterHelper.adapter=adapter;
        FilterHelper.currentList=currentList;
        return new FilterHelper();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();

            //HOLD FILTERS WE FIND
            ArrayList<String> foundFilters=new ArrayList<>();

            String spacecraft;

            //ITERATE CURRENT LIST
            for (int i=0;i<currentList.size();i++)
            {
                spacecraft= currentList.get(i);

                //SEARCH
                if(spacecraft.toUpperCase().contains(constraint))
                {
                    //ADD IF FOUND
                   foundFilters.add(spacecraft);
                }
            }

            //SET RESULTS TO FILTER LIST
            filterResults.count=foundFilters.size();
            filterResults.values=foundFilters;
        }else
        {
            //NO ITEM FOUND.LIST REMAINS INTACT
            filterResults.count=currentList.size();
            filterResults.values=currentList;
        }

        //RETURN RESULTS
        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

        adapter.setSpacecrafts((ArrayList<String>) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}
