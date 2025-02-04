package api.impl;

import model.WorkerNode;

public class AdminServiceImpl {
    private final DistJobScheduler distJobScheduler = DistJobScheduler.getInstance();

    boolean addWorker(WorkerNode workerNode) {
        return distJobScheduler.addWorker(workerNode);
    }

    boolean removeWorker(WorkerNode workerNode) {
        return distJobScheduler.removeWorker(workerNode);
    }
}
