package model;

import java.util.concurrent.locks.ReentrantLock;

public class WorkerNode {
    public String id;
    public long totalCpu;
    public long totalRam;
    public long availableCpu;
    public long availableRam;
    public ReentrantLock lock = new ReentrantLock(true);

    public void allocate(long cpu, long ram) {
        availableCpu -= cpu;
        availableRam -= ram;
    }

    public void deallocate(long reqdCpu, long reqdRam) {
        availableCpu += reqdCpu;
        availableRam += reqdRam;
    }
}
