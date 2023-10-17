package com.example.job_request;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class JobRepository {
    private final Map<Integer, Job> jobMapById = new HashMap<>();
    private final List<Job> sortedJobsList = new ArrayList<>();

    public void save(Job job) {
        // Save to HashMap for quick ID based retrieval
        jobMapById.put(job.getJobId(), job);

        // Insert in sorted order in the ArrayList
        int pos = binarySearchPosition(sortedJobsList, job);
        sortedJobsList.add(pos, job);
    }

    public Optional<Job> findById(Integer jobId) {
        return Optional.ofNullable(jobMapById.get(jobId));
    }

    public List<Job> findAllGreaterThanValue(Integer value) {
        Job dummyJob = new Job(-1, value); // -1 as JobID because it doesn't matter in this case
        int pos = binarySearchPosition(sortedJobsList, dummyJob);
        return sortedJobsList.subList(pos, sortedJobsList.size());
    }

    public boolean deleteById(Integer jobId) {
        Job job = jobMapById.remove(jobId);
        if (job == null) {
            return false;
        }
        sortedJobsList.remove(job);
        return true;
    }

    // Helper method to find the position for insertion using binary search
    private int binarySearchPosition(List<Job> list, Job job) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = Integer.compare(list.get(mid).getJobValue(), job.getJobValue());

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // exact value found, can insert here
            }
        }
        return low; // position where the value should be inserted
    }
}
