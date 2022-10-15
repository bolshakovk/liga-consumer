package liga.common.ligaconsumer.service;

import liga.common.ligaconsumer.api.ReceiveMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static liga.common.ligaconsumer.Config.Config.*;

@Service
@RequiredArgsConstructor
public class ReceiveMessageService implements ReceiveMessage {
    private final ReceiveMessage rM;


    @RabbitListener(queues = {QUEUE_DAILY, QUEUE_ALLERT, QUEUE_ERROR})
    public void receiveMessage(String str) {
        rM.receiveMessage(str);
    }
}
