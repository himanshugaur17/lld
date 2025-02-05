package model;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

import model.enums.JobStatus;

public class WorkerNode {
    public String id;
    public long totalCpu;
    public long totalRam;
    public long availableCpu;
    public long availableRam;
    public ReentrantLock lock = new ReentrantLock(true);

    public boolean executeJob(Job job) {
        job.status = JobStatus.STARTED;
        CompletableFuture.runAsync(() -> {
            System.out.println("job: " + job.id + " running inside: " + Thread.currentThread().getName());
            try {
                Thread.sleep(job.executionTimeInSecs);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("job: " + job.id + " complete");
            job.status = JobStatus.FINISHED_SUCCESSFULLY;
        }).thenAccept((r) -> {
            this.lock.lock();
            this.allocate(job.reqdCpu, job.reqdRam);
            this.lock.unlock();
        });

        return true;
    }

    public void allocate(long cpu, long ram) {
        availableCpu -= cpu;
        availableRam -= ram;
    }

    public void deallocate(long reqdCpu, long reqdRam) {
        availableCpu += reqdCpu;
        availableRam += reqdRam;
    }
}
