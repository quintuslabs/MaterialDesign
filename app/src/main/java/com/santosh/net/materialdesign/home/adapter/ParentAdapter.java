package com.santosh.net.materialdesign.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.santosh.net.materialdesign.R;
import com.santosh.net.materialdesign.home.model.Child;
import com.santosh.net.materialdesign.home.model.Parent;

import java.util.ArrayList;
import java.util.List;


public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {
    private static ChildAdapter adapter;
    List<Child> dataModels = new ArrayList<>();
    private List<Parent> mDataset;
    private Context mContext;

    public ParentAdapter(List<Parent> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parent_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Parent parent = mDataset.get(position);
        Shader textShader = new LinearGradient(0, 0, 100, 20,
                new int[]{Color.BLUE, Color.parseColor("#00BCD4")},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        holder.title.getPaint().setShader(textShader);

        holder.title.setText(parent.getTitle());
        dataModels = parent.getChildList();
        holder.progressBar.setProgress(dataModels.size());
        adapter = new ChildAdapter(dataModels, mContext);
        holder.listView.setAdapter(adapter);

        int totalHeight = 0;
        for (int i = 0; i < parent.getChildList().size(); i++) {
            View listItem = adapter.getView(i, null, holder.listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = holder.listView.getLayoutParams();
        params.height = totalHeight + (holder.listView.getDividerHeight() * (adapter.getCount() - 1));
        holder.listView.setLayoutParams(params);
        holder.listView.requestLayout();


        holder.btnCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.collpased) {
                    holder.collpased = false;
                    holder.llCollapsingLayout.setVisibility(View.VISIBLE);
                    holder.btnCollapse.setImageResource(R.drawable.ic_up_arrow);
                } else {
                    holder.collpased = true;
                    holder.llCollapsingLayout.setVisibility(View.GONE);
                    holder.btnCollapse.setImageResource(R.drawable.ic_down_arrow);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ListView listView;
        ProgressBar progressBar;
        LinearLayout llCollapsingLayout;
        ImageButton btnCollapse;
        boolean collpased = true;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.parent_title);
            listView = itemView.findViewById(R.id.child_LV);
            progressBar = itemView.findViewById(R.id.parent_progress_bar);
            btnCollapse = itemView.findViewById(R.id.btn_collapse);
            llCollapsingLayout = itemView.findViewById(R.id.ll_collapsing_layout);
        }
    }

}