package algos.impl;

import algos.api.JobWorkerNodeMatcherAlgo;
import model.Job;
import model.WorkerNode;

public class DefJobNodeMatcher implements JobWorkerNodeMatcherAlgo {

    @Override
    public boolean matches(Job job, WorkerNode workerNode) {
        return job.reqdCpu <= workerNode.availableCpu && job.reqdRam <= workerNode.availableRam;
    }

}
