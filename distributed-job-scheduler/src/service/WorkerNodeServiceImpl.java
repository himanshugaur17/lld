package service;

import java.util.concurrent.CompletableFuture;

import model.Job;
import model.WorkerNode;
import model.enums.JobStatus;

public class WorkerNodeServiceImpl {
    public boolean execute(Job job, WorkerNode workerNode) {
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
            workerNode.lock.lock();
            workerNode.deallocate(job.reqdCpu, job.reqdRam);
            workerNode.lock.unlock();
        });

        return true;
    }
}
