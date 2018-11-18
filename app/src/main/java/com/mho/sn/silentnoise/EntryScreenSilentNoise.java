package com.mho.sn.silentnoise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mho.sn.silentnoise.settings.persistence.DatabaseSilentNoise;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;

import java.util.List;

public class EntryScreenSilentNoise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen_silent_noise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ///////////////////////////
        DatabaseSilentNoise silentNoiseDb = DatabaseSilentNoise.getDatabase(getApplicationContext());


        ScheduleEntity scheduleEntity = null;

        List<ScheduleEntity> schedulesList = silentNoiseDb.scheduleDao().getAll();
        if (schedulesList == null || schedulesList.isEmpty()) {
            scheduleEntity = new ScheduleEntity();
            scheduleEntity.setScheduleName("NaszScheduleNowy");
            silentNoiseDb.scheduleDao().insert(scheduleEntity);
        } else {
            scheduleEntity = schedulesList.stream().findFirst().get();
            String name = scheduleEntity.getScheduleName();
            scheduleEntity.setScheduleName(name + "\n " + scheduleEntity.getScheduleName().length() + "_nowyName");

            silentNoiseDb.scheduleDao().updateName(scheduleEntity);
        }

        ((TextView) findViewById(R.id.tekstId)).setText(scheduleEntity.getScheduleName());
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
