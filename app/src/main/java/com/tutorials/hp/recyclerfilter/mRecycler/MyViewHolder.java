package com.tutorials.hp.recyclerfilter.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tutorials.hp.recyclerfilter.R;

/**
 * Created by Oclemy on 9/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nametxt;

        public MyViewHolder(View itemView) {
            super(itemView);

            nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        }


}
