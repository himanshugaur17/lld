package observer;

import model.Job;
import model.WorkerNode;

public interface IDistJobSchedulerObserver {

    void registerJob(Job job);

    boolean addWorkerNode(WorkerNode workerNode);

    WorkerNode removeWorker(WorkerNode workerNode);
}
