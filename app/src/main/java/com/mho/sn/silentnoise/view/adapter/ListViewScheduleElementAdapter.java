package com.mho.sn.silentnoise.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.mho.sn.silentnoise.R;
import com.mho.sn.silentnoise.settings.persistence.DatabaseSilentNoise;
import com.mho.sn.silentnoise.settings.persistence.dao.ScheduleDao;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;
import com.mho.sn.silentnoise.utils.ViewUtils;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Kiełbus on 19.11.2018 22:34
 * @project SilentNoise
 */
public class ListViewScheduleElementAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ScheduleEntity> listOfItems;
    private ScheduleDao scheduleDao;
    private int listViewELementResourceId;

    public ListViewScheduleElementAdapter(Context context, List<ScheduleEntity> listOfItems, int listViewELementResourceId) {
        this.context = context;
        this.listOfItems = (ArrayList<ScheduleEntity>) listOfItems;
        this.listViewELementResourceId = listViewELementResourceId;
        this.scheduleDao = ((DatabaseSilentNoise) DatabaseSilentNoise.getDatabase(context)).scheduleDao();
    }

    @Override
    public int getCount() {
        return listOfItems.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return listOfItems.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(listViewELementResourceId, parent, false);
        }

        ScheduleEntity scheduleElement = (ScheduleEntity) getItem(position);

        if (scheduleElement != null) {
            ((TextView) convertView.findViewById(R.id.lv_item_schedule_name)).setText(scheduleElement.getScheduleName());
            if (scheduleElement.isActive()) {
                ((ImageView) convertView.findViewById(R.id.lv_item_imageView_is_active)).setImageResource(R.drawable.ic_check_box_checked_black_26dp);
            } else {
                ((ImageView) convertView.findViewById(R.id.lv_item_imageView_is_active))
                        .setImageResource(R.drawable.ic_check_box_not_checked_black_26dp);

            }

            ((ImageView) convertView.findViewById(R.id.lv_item_imageView_is_active)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scheduleElement.setActive(!scheduleElement.isActive());
                    notifyDataSetChanged();
                }
            });

            convertView.setOnClickListener(v -> {
                ViewUtils.goToView(context, scheduleElement);
            });

            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    PopupMenu popup = new PopupMenu(context, v);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.schedule_scheme_long_click_menu, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.menu_go_to:
                                    ViewUtils.goToView(context, scheduleElement);
                                    return true;
                                case R.id.menu_duplicate:
                                    ScheduleEntity scheduleElementCopy = SerializationUtils.clone(scheduleElement);
                                    scheduleElementCopy.setScheduleName(scheduleElement.getScheduleName() + " (Duplicate)");
                                    scheduleElementCopy.setScheduleId(null);
                                    scheduleDao.insert(scheduleElementCopy);
                                    listOfItems.add(scheduleElementCopy);
                                    notifyDataSetChanged();
                                    return true;
                                case R.id.menu_delete:
                                    scheduleDao.delete(scheduleElement);
                                    listOfItems.remove(scheduleElement);
                                    notifyDataSetChanged();
                                    return true;
                                case R.id.menu_activate_now:
                                    scheduleDao.update(scheduleElement.active(true));
                                    notifyDataSetChanged();
                                    return true;
                                default:
                                    return false;
                            }

                        }
                    });


                    popup.show();

                    return false;
                }
            });

        }

        return convertView;
    }


}
