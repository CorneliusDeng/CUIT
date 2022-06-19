package com.jay.date.util.sys;

/**
 * @author Jay
 */
public class SystemStatus {
    private long freeMemory;
    private long maxMemory;
    private long totalMemory;
    private int availableProcessors;

    public SystemStatus(long freeMemory, long maxMemory, long totalMemory, int availableProcessors) {
        this.freeMemory = freeMemory;
        this.maxMemory = maxMemory;
        this.totalMemory = totalMemory;
        this.availableProcessors = availableProcessors;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(int availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    @Override
    public String toString() {
        return "SystemStatus{" +
                "freeMemory=" + freeMemory +
                ", maxMemory=" + maxMemory +
                ", totalMemory=" + totalMemory +
                ", availableProcessors=" + availableProcessors +
                '}';
    }
}
