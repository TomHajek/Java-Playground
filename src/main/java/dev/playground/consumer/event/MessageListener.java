package dev.playground.consumer.event;

import dev.playground.consumer.configuration.MqConfiguration;
import dev.playground.consumer.dto.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MqConfiguration.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }

}
