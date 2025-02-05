package api.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import model.Job;
import model.WorkerNode;
import observer.IDistJobSchedulerObserver;

public class DistJobScheduler {
    private static DistJobScheduler schedulerInstance;
    /*
     * I could have used Concurrent linked queue
     * But image if i have 1000 of users trying to submit a job
     * it is bound that only 1 will succeed, and rest 999 have to re-try completely
     * huge waste of resources.
     */
    private LinkedBlockingQueue<Job> jobsQueue = new LinkedBlockingQueue<>();
    private List<WorkerNode> workerNodes = new ArrayList<>();
    private final List<IDistJobSchedulerObserver> observers = new ArrayList<>();

    private DistJobScheduler() {

    }

    public static DistJobScheduler getInstance() {
        synchronized (DistJobScheduler.class) {
            if (schedulerInstance == null)
                schedulerInstance = new DistJobScheduler();

        }
        return schedulerInstance;
    }

    public boolean submitJob(Job job) {
        jobsQueue.add(job);
        for (IDistJobSchedulerObserver obs : observers)
            obs.registerJob(job);
        return true;
    }

    public void registerObserver(IDistJobSchedulerObserver observer) {
        observers.add(observer);
    }

    boolean addWorker(WorkerNode workerNode) {
        workerNodes.add(workerNode);
        for (IDistJobSchedulerObserver obs : observers)
            obs.addWorkerNode(workerNode);
        return true;
    }

    boolean removeWorker(WorkerNode workerNode) {
        workerNodes.remove(workerNode);
        for (IDistJobSchedulerObserver obs : observers)
            obs.removeWorker(workerNode);
        return true;
    }
}
