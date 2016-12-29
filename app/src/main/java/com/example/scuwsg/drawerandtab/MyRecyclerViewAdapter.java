package com.example.scuwsg.drawerandtab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Cenoo on 2016/12/28.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private String tabTitle;
    private Context context;

    public MyRecyclerViewAdapter(String tabTitle, Context context) {
        this.tabTitle = tabTitle;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTabTitle.setText(tabTitle);
        holder.tvCardViewPos.setText(context.getString(R.string.cardview, position + 1));
        holder.mImageView.setImageResource(R.drawable.img);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTabTitle;
        TextView tvCardViewPos;
        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            tvTabTitle = (TextView) itemView.findViewById(R.id.tv_tab_title);
            tvCardViewPos = (TextView) itemView.findViewById(R.id.tv_cardview_pos);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
