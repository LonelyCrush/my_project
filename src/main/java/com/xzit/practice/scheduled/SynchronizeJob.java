package com.xzit.practice.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@EnableScheduling
@Slf4j
public class SynchronizeJob {
    
    @Scheduled(cron = "${job.synchronize.cron}")
    public void runWithCron() {
        log.info("run with cron");
    }

    @Scheduled(fixedRate = 1000 * 6)
    public void runWithFixedRate() {
        log.info("run with fixedRate");
    }

    @Scheduled(fixedDelay = 1000 * 7)
    public void runWithFixedDelay() {
        log.info("run with fixedDelay");
    }
}
