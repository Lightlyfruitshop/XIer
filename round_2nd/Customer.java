package round_2nd;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int times;
    private LocalDate lastComeTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public LocalDate getLastComeTime() {
        return lastComeTime;
    }

    public void setLastComeTime(LocalDate lastComeTime) {
        this.lastComeTime = lastComeTime;
    }

    public Customer(String name, LocalDate lastComeTime) {
        this.name = name;
        this.times = 1;
        this.lastComeTime = lastComeTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", times=" + times +
                ", lastComeTime=" + lastComeTime +
                '}';
    }
}
