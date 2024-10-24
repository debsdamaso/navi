package br.com.fiap.navi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class NaviService {

    private final ChatClient chatClient;

    public NaviService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String translate(String text, String style) {
        // Definindo a mensagem do sistema e a mensagem do usuário
        String systemMessage = "Você é um tradutor que adapta o texto para diferentes estilos de escrita.";
        String userMessage = String.format("Traduza o seguinte texto para o estilo '%s': %s", style, text);
        
        // Construindo o prompt e chamando a IA generativa
        return chatClient.prompt()
                         .system(systemMessage)
                         .user(userMessage)
                         .call()
                         .content();
    }
}
