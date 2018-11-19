package com.mho.sn.silentnoise.view.element;

/**
 * @author Gabriel Kiełbus on 19.11.2018 22:27
 * @project SilentNoise
 */
public class ListViewScheduleElement {

    private String scheduleName;
    private boolean active;

    public ListViewScheduleElement(String scheduleName, boolean active) {
        this.scheduleName = scheduleName;
        this.active = active;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public ListViewScheduleElement setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public ListViewScheduleElement setActive(boolean active) {
        this.active = active;
        return this;
    }

}
