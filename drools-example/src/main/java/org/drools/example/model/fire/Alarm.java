package org.drools.example.model.fire;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class Alarm {

    private Fire fire;

    public Alarm(Fire fire) {
        this.fire = fire;
    }

    public Fire getFire() {
        return fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alarm alarm = (Alarm) o;

        return fire != null ? fire.equals(alarm.fire) : alarm.fire == null;
    }

    @Override
    public int hashCode() {
        return fire != null ? fire.hashCode() : 0;
    }
}
