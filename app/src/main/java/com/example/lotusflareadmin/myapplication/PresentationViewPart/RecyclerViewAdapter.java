package com.example.lotusflareadmin.myapplication.PresentationViewPart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lotusflareadmin.myapplication.R;

/**
 * Created by Ana Nedic.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private int mNumberItems;

    public RecyclerViewAdapter(int mNumberItems) {
        this.mNumberItems = mNumberItems;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent,
                false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    } //todo: fetch from cursor

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView taskName;
        private CheckBox isTaskDone;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.taskName);
            isTaskDone = itemView.findViewById(R.id.is_task_done);
        }

        void bind(int listIndex) { //TODO: change this
            taskName.setText(String.valueOf(listIndex));
            isTaskDone.setChecked(false);
        } // Be careful to get the String representation of listIndex,
            // as using setText with an int does something different!!!
            //Using setText(int... ) may crash your app!
    }
}
