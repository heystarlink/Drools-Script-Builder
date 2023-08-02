package org.drools.example.model.fire;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class Sprinkler {

    public Sprinkler(Room room, boolean on) {
        this.room = room;
        this.on = on;
    }

    public Sprinkler(Room room) {
        this.room = room;
    }

    private Room room;
    private boolean on;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sprinkler sprinkler = (Sprinkler) o;

        if (on != sprinkler.on) return false;
        return room != null ? room.equals(sprinkler.room) : sprinkler.room == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (on ? 1 : 0);
        return result;
    }
}
