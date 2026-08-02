package com.email.email_writer.service;

import java.util.List;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.email.email_writer.dto.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ChatServiceImpl implements ChatService {

	private final ChatClient chatClient ;
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public ChatServiceImpl(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	
//	public UserInfo extractUserInfo(String text)
//	 throws Exception
//	{
//		
//		Prompt prompt = new Prompt(				
//		List.of(
//				new SystemMessage("You are a helpful assistant that extracts user information from text. The user information includes name, email, and role. Please provide the extracted information in JSON format."),
//				new SystemMessage("Extract the user information from the following text: " + text
//				)		
//					));
//				
//				
//		ChatResponse response = chatClient.call(prompt);
//		
//		return objectMapper.readValue(
//			    response.getResults().get(0).getOutput().getContent(),
//			    UserInfo.class
//			);
//
//	    
//	}
	@Override
	public UserInfo extractUserInfo(String text) throws Exception {
	    Prompt prompt = new Prompt(List.of(
	        new SystemMessage("You are an assistant. Return ONLY valid JSON."),
	        new UserMessage("Extract details from: " + text)
	    ));

	    ChatResponse response = chatClient.call(prompt);
	    String rawOutput = response.getResults().get(0).getOutput().getContent();

	    // Clean response
	    int start = rawOutput.indexOf("{");
	    int end = rawOutput.lastIndexOf("}") + 1;
	    String jsonOnly = rawOutput.substring(start, end);

	    return objectMapper.readValue(jsonOnly, UserInfo.class);
	}

}
