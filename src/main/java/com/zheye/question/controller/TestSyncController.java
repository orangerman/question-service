package com.zheye.question.controller;

import com.zheye.question.util.MutexUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/testSync")
public class TestSyncController {

    @GetMapping("/process/{orderId}")
    public Map<String, Object> testSync(@PathVariable("orderId") String orderId) {
        MutexUtil.exec(orderId, () -> {
            log.debug("[{}] start", orderId);
            service();
            log.debug("[{}] end", orderId);
        });
        return new HashMap<>();
    }

    private void service() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

