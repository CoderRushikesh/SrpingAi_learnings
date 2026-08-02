package com.email.email_writer.service;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

	private final OllamaChatClient ollamaChatClient;
	
	public OllamaService(OllamaChatClient ollamaChatClient) {
		this.ollamaChatClient = ollamaChatClient;
	}
	
	public String generateEmail(String prompt) {
		return ollamaChatClient.call(prompt);
	}
}
