package com.email.email_writer.Controller;




import com.email.email_writer.dto.UserInfo;
import com.email.email_writer.service.ChatService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // Parsing Responses Endpoint
    @PostMapping("/extract")
    public UserInfo extract(@RequestBody String text) throws Exception {
        return chatService.extractUserInfo(text);
    }

    // Streaming Responses Endpoint
    
}
