package com.davidmonroy.springbootlibrary.controller;

import com.davidmonroy.springbootlibrary.entity.History;
import com.davidmonroy.springbootlibrary.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/history")
public class HistoryController {
    
    private HistoryService historyService;
    
    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }
    
    @GetMapping("/secure")
    public Page<History> getUserHistory(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        
        String userEmail = jwt.getClaim("email");
        return historyService.getUserHistory(userEmail, page, size);
    }
}
