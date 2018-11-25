package com.mho.sn.silentnoise.settings.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * @author Gabriel Kiełbus on 15.11.2018 20:39
 * @project SoundsManager
 */
@Entity
public class ScheduleEntity implements Serializable {

    @Ignore
    private static final long serialVersionUID = 6271391360607488563L;

    @PrimaryKey(autoGenerate = true)
    private int scheduleId;

    @ColumnInfo
    private String scheduleName;

    @ColumnInfo
    private int ringhtoneVolLvl;

    @ColumnInfo
    private int notificationVolLvl;

    @ColumnInfo
    private int alarmVolLvl;

    @ColumnInfo
    private int systemVolLvl;

    @ColumnInfo
    private int mediaVolLvl;

    @ColumnInfo
    private boolean vibrateOnCall;

    @ColumnInfo
    private boolean vibrateOnNotification;

    @ColumnInfo
    private boolean customRinghtone;

    @ColumnInfo
    private String ringhtoneName;

    @ColumnInfo
    private boolean wifiActive;

    @ColumnInfo
    private boolean bluetoothActive;

    @ColumnInfo
    private boolean gpsActive;

    @ColumnInfo
    private String startTime;

    @ColumnInfo
    private String stopTime;

    @Embedded(prefix = "mon_")
    private ScheduleDaySettings monScheduleDaySettings;

    @Embedded(prefix = "tue_")
    private ScheduleDaySettings tuesScheduleDaySettings;

    @Embedded(prefix = "wen_")
    private ScheduleDaySettings wednesScheduleDaySettings;

    @Embedded(prefix = "thu_")
    private ScheduleDaySettings thursday;

    @Embedded(prefix = "fri_")
    private ScheduleDaySettings friScheduleDaySettings;

    @Embedded(prefix = "sat_")
    private ScheduleDaySettings saturScheduleDaySettings;

    @Embedded(prefix = "sun_")
    private ScheduleDaySettings sunScheduleDaySettings;

    @Ignore
    private boolean active;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public int getRinghtoneVolLvl() {
        return ringhtoneVolLvl;
    }

    public void setRinghtoneVolLvl(int ringhtoneVolLvl) {
        this.ringhtoneVolLvl = ringhtoneVolLvl;
    }

    public int getNotificationVolLvl() {
        return notificationVolLvl;
    }

    public void setNotificationVolLvl(int notificationVolLvl) {
        this.notificationVolLvl = notificationVolLvl;
    }

    public int getAlarmVolLvl() {
        return alarmVolLvl;
    }

    public void setAlarmVolLvl(int alarmVolLvl) {
        this.alarmVolLvl = alarmVolLvl;
    }

    public int getSystemVolLvl() {
        return systemVolLvl;
    }

    public void setSystemVolLvl(int systemVolLvl) {
        this.systemVolLvl = systemVolLvl;
    }

    public int getMediaVolLvl() {
        return mediaVolLvl;
    }

    public void setMediaVolLvl(int mediaVolLvl) {
        this.mediaVolLvl = mediaVolLvl;
    }

    public boolean isVibrateOnCall() {
        return vibrateOnCall;
    }

    public void setVibrateOnCall(boolean vibrateOnCall) {
        this.vibrateOnCall = vibrateOnCall;
    }

    public boolean isVibrateOnNotification() {
        return vibrateOnNotification;
    }

    public void setVibrateOnNotification(boolean vibrateOnNotification) {
        this.vibrateOnNotification = vibrateOnNotification;
    }

    public boolean isCustomRinghtone() {
        return customRinghtone;
    }

    public void setCustomRinghtone(boolean customRinghtone) {
        this.customRinghtone = customRinghtone;
    }

    public String getRinghtoneName() {
        return ringhtoneName;
    }

    public void setRinghtoneName(String ringhtoneName) {
        this.ringhtoneName = ringhtoneName;
    }

    public boolean isWifiActive() {
        return wifiActive;
    }

    public void setWifiActive(boolean wifiActive) {
        this.wifiActive = wifiActive;
    }

    public boolean isBluetoothActive() {
        return bluetoothActive;
    }

    public void setBluetoothActive(boolean bluetoothActive) {
        this.bluetoothActive = bluetoothActive;
    }

    public boolean isGpsActive() {
        return gpsActive;
    }

    public void setGpsActive(boolean gpsActive) {
        this.gpsActive = gpsActive;
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

    public ScheduleDaySettings getMonScheduleDaySettings() {
        return monScheduleDaySettings;
    }

    public void setMonScheduleDaySettings(ScheduleDaySettings monScheduleDaySettings) {
        this.monScheduleDaySettings = monScheduleDaySettings;
    }

    public ScheduleDaySettings getTuesScheduleDaySettings() {
        return tuesScheduleDaySettings;
    }

    public void setTuesScheduleDaySettings(ScheduleDaySettings tuesScheduleDaySettings) {
        this.tuesScheduleDaySettings = tuesScheduleDaySettings;
    }

    public ScheduleDaySettings getWednesScheduleDaySettings() {
        return wednesScheduleDaySettings;
    }

    public void setWednesScheduleDaySettings(ScheduleDaySettings wednesScheduleDaySettings) {
        this.wednesScheduleDaySettings = wednesScheduleDaySettings;
    }

    public ScheduleDaySettings getThursday() {
        return thursday;
    }

    public void setThursday(ScheduleDaySettings thursday) {
        this.thursday = thursday;
    }

    public ScheduleDaySettings getFriScheduleDaySettings() {
        return friScheduleDaySettings;
    }

    public void setFriScheduleDaySettings(ScheduleDaySettings friScheduleDaySettings) {
        this.friScheduleDaySettings = friScheduleDaySettings;
    }

    public ScheduleDaySettings getSaturScheduleDaySettings() {
        return saturScheduleDaySettings;
    }

    public void setSaturScheduleDaySettings(ScheduleDaySettings saturScheduleDaySettings) {
        this.saturScheduleDaySettings = saturScheduleDaySettings;
    }

    public ScheduleDaySettings getSunScheduleDaySettings() {
        return sunScheduleDaySettings;
    }

    public void setSunScheduleDaySettings(ScheduleDaySettings sunScheduleDaySettings) {
        this.sunScheduleDaySettings = sunScheduleDaySettings;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
