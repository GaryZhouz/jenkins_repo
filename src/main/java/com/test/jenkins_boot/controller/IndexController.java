package com.test.jenkins_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) throws UnknownHostException {
        model.addAttribute("hostname", InetAddress.getLocalHost());
        return "index";
    }
}
