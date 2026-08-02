package com.email.email_writer.service;

import com.email.email_writer.dto.UserInfo;

public interface ChatService {

	
	UserInfo extractUserInfo(String text) throws Exception;
}
