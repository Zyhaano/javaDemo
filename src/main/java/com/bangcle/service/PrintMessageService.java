package com.bangcle.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintMessageService {

    public void doJob() {
        while (true) {
            try {
                printMessage();
                Thread.sleep(1000 * 3);
            } catch (Exception e) {
                log.error("", e);
            }
        }
    }

    private void printMessage() {
        log.info("print message, time:{}", System.currentTimeMillis());
    }
}
