package com.example.job_request;

public class Job {
    private int jobId;
    private int jobValue;

    // Default constructor
    public Job() {}

    // Parameterized constructor
    public Job(int jobId, int jobValue) {
        this.jobId = jobId;
        this.jobValue = jobValue;
    }

    // Getter for jobId
    public int getJobId() {
        return jobId;
    }

    // Setter for jobId
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    // Getter for jobValue
    public int getJobValue() {
        return jobValue;
    }

    // Setter for jobValue
    public void setJobValue(int jobValue) {
        this.jobValue = jobValue;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobValue=" + jobValue +
                '}';
    }
}
