package com.email.email_writer.Controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.email.email_writer.service.OllamaService;

@RestController
@RequestMapping("/api")
public class OllamaController {

	private final OllamaService ollamaService;
	
	public OllamaController(OllamaService ollamaService) {
		this.ollamaService = ollamaService;
	}
	
	@GetMapping("/ask")
	public String EmailGenerator(@RequestParam String prompt)
	{
		return ollamaService.generateEmail(prompt);
	}
	
	
	
	
	
}
