package com.mho.sn.silentnoise.settings.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mho.sn.silentnoise.settings.persistence.dao.ScheduleDao;
import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;

/**
 * @author Gabriel Kiełbus on 15.11.2018 22:47
 * @project SoundsManager
 */
@Database(entities = {ScheduleEntity.class}, version = 1, exportSchema = false)
public abstract class DatabaseSilentNoise extends RoomDatabase {

    private static volatile DatabaseSilentNoise INSTANCE;

    public abstract ScheduleDao scheduleDao();

    public static DatabaseSilentNoise getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseSilentNoise.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseSilentNoise.class, "silent-noise-database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
