package model;

import model.enums.JobStatus;

public class Job implements Comparable<Job> {
    public String id;
    public long executionTimeInSecs;
    public long reqdCpu;
    public long reqdRam;
    public long priority;
    public JobStatus status;

    @Override
    public int compareTo(Job job2) {
        return Long.compare(priority, job2.priority);
    }

}
