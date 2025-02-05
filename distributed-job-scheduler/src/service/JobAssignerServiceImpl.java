package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import algos.api.JobWorkerNodeMatcherAlgo;
import algos.impl.DefJobNodeMatcher;
import model.Job;
import model.WorkerNode;
import observer.IDistJobSchedulerObserver;

public class JobAssignerServiceImpl implements IDistJobSchedulerObserver, Runnable {
    private final LinkedBlockingQueue<Job> jobs = new LinkedBlockingQueue<>();
    private final List<WorkerNode> workerNodes = new ArrayList<>();
    private final JobWorkerNodeMatcherAlgo jobWorkerNodeMatcherAlgo = new DefJobNodeMatcher();

    @Override
    public void run() {
        Job job = jobs.poll();
        while (true) {
            WorkerNode wN = this.workerNodes.get(new Random().nextInt(this.workerNodes.size()));
            if (job == null) {
                System.out.println(
                        "No job available for job assigner thread: " + Thread.currentThread().getName()
                                + " hence i will sleep for sometime");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            wN.lock.lock();
            boolean match = jobWorkerNodeMatcherAlgo.matches(job, wN);
            if (match) {
                wN.allocate(job.reqdCpu, job.reqdRam);
            }
            wN.lock.unlock();
            if (!match)
                continue;

            wN.executeJob(job);
        }
    }

    @Override
    public void registerJob(Job job) {
        jobs.add(job);
    }

    @Override
    public boolean addWorkerNode(WorkerNode workerNode) {
        return workerNodes.add(workerNode);
    }

    @Override
    public WorkerNode removeWorker(WorkerNode workerNode) {
        workerNodes.remove(workerNode);
        return workerNode;
    }

}
