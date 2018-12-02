package com.mho.sn.silentnoise.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mho.sn.silentnoise.R;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;
import com.mho.sn.silentnoise.utils.IntentPassElementCnsts;

public class ScheduleElementActivity extends AppCompatActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_element_view_activity);

        /* Dodanie moje widok nazwy schedula */
        Intent intent = getIntent();
        ScheduleEntity scheduleEntity = (ScheduleEntity) intent.getSerializableExtra(IntentPassElementCnsts.SCHEDULE_ELEMENT_KEY);

        // Capture the layout's TextView and set the string as its text
        mTextMessage = (TextView) findViewById(R.id.scheme_name_title_on_sv_id);
        mTextMessage.setText(scheduleEntity.getScheduleName());

    }

}
