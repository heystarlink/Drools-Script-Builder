package org.drools.example.model.fire;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class Fire {
    private Room room;

    public Fire() {
    }

    public Fire(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fire fire = (Fire) o;

        return room != null ? room.equals(fire.room) : fire.room == null;
    }

    @Override
    public int hashCode() {
        return room != null ? room.hashCode() : 0;
    }
}
