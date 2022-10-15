package liga.common.ligaconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.common.ligaconsumer.api.ReceiveMessage;
import liga.common.ligaconsumer.model.RabbitMessageDTO;
import liga.common.ligaconsumer.model.Type;
import org.springframework.stereotype.Service;

import static liga.common.ligaconsumer.Config.Config.*;

@Service
public class ReceiveMessageServiceImp implements ReceiveMessage {




    @Override
    public void receiveMessage(String str)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(str, RabbitMessageDTO.class);
            Type type = rabbitMessageDTO.getType();
            String queue = "";
            switch (type){
                case DAILY -> queue = QUEUE_DAILY;
                case ALLERT -> queue = QUEUE_ALLERT;
                case ERROR -> queue = QUEUE_ERROR;
            }
            System.out.println("received message: " + str + " from queue: " + queue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
