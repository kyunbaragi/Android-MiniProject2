package com.project2.mini.yunkyun.miniproject2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by YunKyun on 2017-07-11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public static final int SORT_BY_DISTANCE = 0;
    public static final int SORT_BY_POPULARITY = 1;
    public static final int SORT_BY_RECENT = 2;

    private ArrayList<StoreItem> itemList = null;

    public RecyclerAdapter() {
        this.itemList = new ArrayList<>();
    }

    public void setItemList(ArrayList<StoreItem> items) {
        itemList.clear();
        itemList.addAll(items);
    }

    public void sortItemList(int option) {
        switch(option){
            case SORT_BY_DISTANCE:
                Collections.sort(itemList, new Comparator<StoreItem>() {
                    @Override
                    public int compare(StoreItem o1, StoreItem o2) {
                        return (int)o1.getDistance() - (int)o2.getDistance();
                    }
                });
                break;
            case SORT_BY_POPULARITY:
                Collections.sort(itemList, new Comparator<StoreItem>() {
                    @Override
                    public int compare(StoreItem o1, StoreItem o2) {
                        return o1.getPopularity() - o2.getPopularity();
                    }
                });
                break;
            case SORT_BY_RECENT:
                Collections.sort(itemList, new Comparator<StoreItem>() {
                    @Override
                    public int compare(StoreItem o1, StoreItem o2) {
                        return o1.getRecent() - o2.getRecent();
                    }
                });
                break;
            default:
                break;
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
