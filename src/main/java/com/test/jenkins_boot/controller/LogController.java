package com.test.jenkins_boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class LogController {

    protected final static Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/api/log")
    public Object log(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String uri = request.getRequestURI();
        String logStr = String.format("IP=[%s] send request URI = [%s]", ip, uri);
        log.debug("[debug] " + logStr);
        log.info("[info] " + logStr);
        log.warn("[warn] " + logStr);
        log.error("[error] " + logStr);
        return "OK : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
