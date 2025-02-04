package api.impl;

import model.Job;
import model.JobInfo;
import model.WorkerNode;

public class DistJobScheduler {
    private static DistJobScheduler schedulerInstance;

    private DistJobScheduler() {

    }

    public static DistJobScheduler getInstance() {
        synchronized (DistJobScheduler.class) {
            if (schedulerInstance == null)
                schedulerInstance = new DistJobScheduler();

        }
        return schedulerInstance;
    }

    public boolean submitJob(Job<?> job) {
        return true;
    }

    public JobInfo jobInfo(String jobId) {
        return null;
    }

    boolean addWorker(WorkerNode workerNode) {
        return true;
    }

    boolean removeWorker(WorkerNode workerNode) {
        return true;
    }
}
