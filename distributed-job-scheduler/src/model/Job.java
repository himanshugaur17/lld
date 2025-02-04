package model;

import model.enums.JobStatus;

public class Job<T> {
    String id;
    Long startTime;
    Long finishTime;
    JobStatus jobStatus;
    String message;
    Task<T> task;
}
