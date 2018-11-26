package com.mho.sn.silentnoise.utils;

import android.content.Context;
import android.content.Intent;

import com.mho.sn.silentnoise.activities.ScheduleElementActivity;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;

/**
 * @author Gabriel Kiełbus on 26.11.2018 21:29
 * @project SilentNoise
 */
public final class ViewUtils {

    public static final void goToView(Context context, ScheduleEntity scheduleEntity) {
        Intent intent = new Intent(context, ScheduleElementActivity.class);
        intent.putExtra(IntentPassElementCnsts.SCHEDULE_ELEMENT_KEY, scheduleEntity);
        context.startActivity(intent);
    }

    private ViewUtils() {
    }
}
