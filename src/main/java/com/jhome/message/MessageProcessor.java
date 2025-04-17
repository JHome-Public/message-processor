package com.jhome.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class MessageProcessor {

    @Bean
    public Function<Message<String>, Message<String>> processMessage() {
        return message -> {
            String processedMessage = "Processed message: " + message.getPayload().toUpperCase();
            log.info(processedMessage);
            return MessageBuilder.withPayload(processedMessage).build();
        };
    }
}
