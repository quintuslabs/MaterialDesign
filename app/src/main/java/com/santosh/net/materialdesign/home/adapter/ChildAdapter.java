package com.santosh.net.materialdesign.home.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.santosh.net.materialdesign.R;
import com.santosh.net.materialdesign.animation.BasicAnimation;
import com.santosh.net.materialdesign.home.model.Child;

import java.util.List;

public class ChildAdapter extends ArrayAdapter<Child> implements View.OnClickListener {
    Intent intent;
    Context mContext;
    private List<Child> dataSet;
    private int lastPosition = -1;

    public ChildAdapter(List<Child> data, Context context) {
        super(context, R.layout.child_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Child dataModel = (Child) object;

        selectItem(dataModel.getId());

//        switch (v.getId()) {
//            case R.id.child_title:
//                Snackbar.make(v, "Release date " + dataModel.getTitle(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Child dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.child_item, parent, false);
            viewHolder.title = convertView.findViewById(R.id.child_title);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.title.setText(dataModel.getTitle());
        viewHolder.title.setOnClickListener(this);
        viewHolder.title.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

    private void selectItem(int id) {
        switch (id) {
            case 101:
                intent = new Intent(mContext, BasicAnimation.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                break;
            case 102:

                break;
            case 103:

                break;

            default:
                break;
        }
    }

    // View lookup cache
    private static class ViewHolder {
        TextView title;

    }

}

