package com.mho.sn.silentnoise.settings.persistence.entity;


import android.arch.persistence.room.Entity;

/**
 * @author Gabriel Kiełbus on 15.11.2018 22:02
 * @project SoundsManager
 */
@Entity
public class ScheduleDaySettings {

    private boolean settingActive;

    private boolean dedicatedTimeSetup;

    private String startTime;

    private String stopTime;

    public boolean isSettingActive() {
        return settingActive;
    }

    public void setSettingActive(boolean settingActive) {
        this.settingActive = settingActive;
    }

    public boolean isDedicatedTimeSetup() {
        return dedicatedTimeSetup;
    }

    public void setDedicatedTimeSetup(boolean dedicatedTimeSetup) {
        this.dedicatedTimeSetup = dedicatedTimeSetup;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
}
