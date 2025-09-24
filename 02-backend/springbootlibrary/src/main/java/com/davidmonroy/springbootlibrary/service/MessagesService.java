package com.davidmonroy.springbootlibrary.service;


import com.davidmonroy.springbootlibrary.dao.MessageRepository;
import com.davidmonroy.springbootlibrary.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesService {

    private MessageRepository messageRepository;

    @Autowired
    public MessagesService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Message messageRequest, String userEmail) {
        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }

    public Page<Message> getUserMessages(String userEmail, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageRepository.findByUserEmail(userEmail, pageable);
    }
}
