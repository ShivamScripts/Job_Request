package com.example.job_request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addJob(@RequestParam int jobId, @RequestParam int jobValue) {
        jobService.addJob(jobId, jobValue);
        return ResponseEntity.ok(Map.of("stat", "ok"));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAll(@RequestParam(required = false) Integer jobValue) {
        if (jobValue == null) {
            jobValue = Integer.MIN_VALUE;
        }
        return ResponseEntity.ok(jobService.getAllJobsByValue(jobValue));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Map<String, String>> deleteJobById(@RequestParam int jobId) {
        if (jobService.deleteJobById(jobId)) {
            return ResponseEntity.ok(Map.of("stat", "ok"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("stat", "not found"));
        }
    }
}
