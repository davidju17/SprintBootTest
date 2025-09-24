package com.davidmonroy.springbootlibrary.controller;

import com.davidmonroy.springbootlibrary.entity.Message;
import com.davidmonroy.springbootlibrary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/message")
public class MessageController {
    
    private MessageService messageService;
    
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    
    @GetMapping("/secure")
    public Page<Message> getUserMessages(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        
        String userEmail = jwt.getClaim("email");
        return messageService.getUserMessages(userEmail, page, size);
    }
}
