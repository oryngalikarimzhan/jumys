package com.job.jumys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.jumys.service.CandidateService;
import com.job.jumys.service.SimpleCandidateService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateService candidateService = SimpleCandidateService.getInstance();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/list";
    }

    @GetMapping("/create")
    public String getCreationPage() {
        return "candidates/create";
    }
}
