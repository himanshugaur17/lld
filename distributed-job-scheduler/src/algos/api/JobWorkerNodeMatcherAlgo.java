package algos.api;

import model.Job;
import model.WorkerNode;

public interface JobWorkerNodeMatcherAlgo {
    boolean matches(Job job, WorkerNode workerNode);
}
