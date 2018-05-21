package com.adidroid.calculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyListItem> mDataset;
    private View.OnClickListener listener;

    public MyAdapter(ArrayList<MyListItem> myDataset,View.OnClickListener listener) {
        this.mDataset  = myDataset;
        this.listener = listener;
        setHasStableIds(true);
    }

    /**
     * Creates new views (invoked by the layout manager)
     * The parent will take care of recycling as needed according to the viewType, so no need to
     * worry about it.
     * The method will be called once per item on the screen, and not once per item in the list.
     * I.e. an item off the screen will automatically be recycled and used for one entering the
     * screen. Hence the name of the class (RecyclerList).
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        return new ViewHolder(itemView);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyListItem myListItem = mDataset.get(position);
        holder.mTitle.setText(myListItem.toString());
        holder.mTitle.setOnClickListener(listener);
        holder.mTitle.setTag(myListItem); // a handy way to pass any data to a view

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTitle ;

        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.title);;
        }

    }

}
