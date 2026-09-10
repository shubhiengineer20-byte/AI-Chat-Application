package com.chatapplication.ollama.advisors;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.api.OllamaApi;

import java.util.logging.Logger;


public class TokenUsageAuditAdvisor implements CallAdvisor {

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest); // response from LLM
        ChatResponse chatResponse= chatClientResponse.chatResponse();

        if(chatResponse.getMetadata()!=null){
            Usage usage= chatResponse.getMetadata().getUsage();
        }
        return chatClientResponse ;
    }

    @Override
    public String getName() {
        return "TokenUsageAuditAdvisor3";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
