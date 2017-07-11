package com.project2.mini.yunkyun.miniproject2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YunKyun on 2017-07-11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<StoreItem> itemList = null;
    private Context context = null;

    public RecyclerAdapter(Context context) {
        this.itemList = new ArrayList<>();
        this.context = context;
    }

    public void addItem(StoreItem item){
        itemList.add(item);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final StoreItem item = itemList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.checkBox.setChecked(item.isChecked());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                item.setChecked(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name = null;
        private TextView description = null;
        private CheckBox checkBox = null;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_store_item_name);
            description = itemView.findViewById(R.id.tv_store_item_desc);
            checkBox = itemView.findViewById(R.id.checkBox_store_item);
        }
    }
}
