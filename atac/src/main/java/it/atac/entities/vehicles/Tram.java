package it.atac.entities.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trams")
public class Tram extends Vehicle{

    @Column(nullable = false)
    private int capacity;

    public Tram(boolean isWorking, int totalRoutes) {
        super(isWorking, totalRoutes);
        this.capacity = 120;
    }

    public Tram() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "capacity=" + capacity +
                ", id=" + id +
                ", isWorking=" + isWorking +
                ", totalRoutes=" + totalRoutes +
                '}';
    }
}
