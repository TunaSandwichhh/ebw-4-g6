package it.atac.entities.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "buses")
public class Bus extends Vehicle{

    @Column(nullable = false)
    private int capacity = 50;

    public Bus(boolean isWorking, int totalRoutes) {
        super(isWorking, totalRoutes);
    }

    public Bus() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + capacity +
                ", id=" + id +
                ", isWorking=" + isWorking +
                ", totalRoutes=" + totalRoutes +
                '}';
    }
}
