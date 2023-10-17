package com.example.job_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(int jobId, int jobValue) {
        Job job = new Job(jobId, jobValue);
        jobRepository.save(job);
    }

    public Optional<Job> getJobById(Integer jobId) {
        return jobRepository.findById(jobId);
    }

    public List<Job> getAllJobsByValue(Integer value) {
        return jobRepository.findAllGreaterThanValue(value);
    }

    public boolean deleteJobById(Integer jobId) {
        return jobRepository.deleteById(jobId);
    }
}
