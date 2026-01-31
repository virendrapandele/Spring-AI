package com.project.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private final ChatClient chatClient;
	
	public HomeController(ChatClient.Builder chatClientBuilder)
	{
		this.chatClient = chatClientBuilder.build();
	}

	@GetMapping("/chat")
	public String home(@RequestParam String msg) {
		
		return chatClient.prompt()
				.user(msg)
				.call()
				.content();
	}
}
