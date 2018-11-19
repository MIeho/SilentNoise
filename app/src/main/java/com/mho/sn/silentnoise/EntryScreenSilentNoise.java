package com.mho.sn.silentnoise;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.mho.sn.silentnoise.settings.persistence.DatabaseSilentNoise;
import com.mho.sn.silentnoise.settings.persistence.dao.ScheduleDao;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;
import com.mho.sn.silentnoise.view.adapter.ListViewScheduleElementAdapter;
import com.mho.sn.silentnoise.view.element.ListViewScheduleElement;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntryScreenSilentNoise extends AppCompatActivity {

    private ListViewScheduleElementAdapter adapter;
    private int scheduleId = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen_silent_noise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ///////////////////////////
        ScheduleDao scheduleDao = ((DatabaseSilentNoise) DatabaseSilentNoise.getDatabase(getApplicationContext())).scheduleDao();

        ScheduleEntity scheduleEntity = null;

        List<ScheduleEntity> schedulesList = scheduleDao.getAll();
        if (schedulesList == null || schedulesList.isEmpty()) {
            scheduleEntity = new ScheduleEntity();
            scheduleEntity.setScheduleName("NaszScheduleNowy");
            scheduleDao.insert(scheduleEntity);
        } else {
            scheduleEntity = schedulesList.stream().findFirst().get();
            String name = scheduleEntity.getScheduleName();
            scheduleEntity.setScheduleName(name + "\n " + scheduleId++ + "_nowyName");
            scheduleDao.updateName(scheduleEntity);


        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_schedule_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added new schedule", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                scheduleEntity.setScheduleName("ScheduleNext" + scheduleId++);
                scheduleDao.insert(scheduleEntity);

                List<ScheduleEntity> schedulesList = scheduleDao.getAll();
                ArrayList<ListViewScheduleElement> listOfSchedulesLVElements = (ArrayList<ListViewScheduleElement>) schedulesList
                        .stream().map(schedule -> new ListViewScheduleElement(schedule.getScheduleName(), true)).collect(Collectors.toList());
                adapter = new ListViewScheduleElementAdapter(getApplicationContext(), R.layout.schedule_list_view_element, listOfSchedulesLVElements);
                ((ListView) findViewById(R.id.listOfSchedulesId)).setAdapter(adapter);
            }
        });

        ArrayList<ListViewScheduleElement> listOfSchedulesLVElements =
                (ArrayList<ListViewScheduleElement>) schedulesList
                        .stream().map(schedule -> new ListViewScheduleElement(schedule.getScheduleName(), true)).collect(Collectors.toList());
        adapter = new ListViewScheduleElementAdapter(getApplicationContext(), R.layout.schedule_list_view_element, listOfSchedulesLVElements);

        ((ListView) findViewById(R.id.listOfSchedulesId)).setAdapter(adapter);
////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entry_screen_silent_noise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
