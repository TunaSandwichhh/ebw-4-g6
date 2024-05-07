package it.atac.entities.vehicles;

public class Bus extends Vehicle{
    private int capacity;

    public Bus(boolean isWorking, int totalRoutes) {
        super(isWorking, totalRoutes);
        this.capacity = 50;
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
