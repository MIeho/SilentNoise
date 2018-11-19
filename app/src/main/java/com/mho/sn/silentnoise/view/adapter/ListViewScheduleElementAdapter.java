package com.mho.sn.silentnoise.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mho.sn.silentnoise.R;
import com.mho.sn.silentnoise.view.element.ListViewScheduleElement;

import java.util.ArrayList;

/**
 * @author Gabriel Kiełbus on 19.11.2018 22:34
 * @project SilentNoise
 */
public class ListViewScheduleElementAdapter extends ArrayAdapter<ListViewScheduleElement> implements View.OnUnhandledKeyEventListener{


    private final LayoutInflater mInflater;
    private ArrayList<ListViewScheduleElement> scheduleElementsList;
    private int listViewItemResourceId;

    public ListViewScheduleElementAdapter(Context context, int listViewItemResourceId, ArrayList<ListViewScheduleElement> scheduleElementsList) {
        super(context, listViewItemResourceId);
        this.scheduleElementsList = scheduleElementsList;
        this.mInflater = LayoutInflater.from(context);
        this.listViewItemResourceId = listViewItemResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.schedule_list_view_element, null);
        } else {
            view = convertView;
        }

        ListViewScheduleElement scheduleElement = scheduleElementsList.get(position);

        if (scheduleElement != null) {
            ((TextView) view.findViewById(R.id.lv_item_schedule_name)).setText(scheduleElement.getScheduleName());
            if (scheduleElement.isActive()) {
                ((ImageView) view.findViewById(R.id.lv_item_imageView_is_active)).setImageResource(R.drawable.ic_check_box_checked_black_26dp);
            } else {
                ((ImageView) view.findViewById(R.id.lv_item_imageView_is_active)).setImageResource(R.drawable.ic_check_box_not_checked_black_26dp);
            }

        }

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
