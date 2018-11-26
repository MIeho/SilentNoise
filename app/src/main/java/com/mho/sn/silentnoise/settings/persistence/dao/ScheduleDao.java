package com.mho.sn.silentnoise.settings.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mho.sn.silentnoise.settings.persistence.entity.ScheduleEntity;

import java.util.List;

/**
 * @author Gabriel Kiełbus on 15.11.2018 22:20
 * @project SoundsManager
 */
@Dao
public interface ScheduleDao {

    @Query("SELECT * FROM scheduleentity")
    List<ScheduleEntity> getAll();

    @Query("SELECT * FROM scheduleentity WHERE scheduleId =:scheduleId")
    List<ScheduleEntity> loadById(int scheduleId);

    @Query("SELECT * FROM scheduleentity WHERE scheduleName LIKE :scheduleName LIMIT 1")
    ScheduleEntity findByName(String scheduleName);

    @Update
    void update(ScheduleEntity scheduleEntity);

    @Insert
    void insert(ScheduleEntity scheduleEntity);

    @Delete
    void delete(ScheduleEntity schedule);

}
