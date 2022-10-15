package liga.common.ligaconsumer.model;

import lombok.Data;

@Data
public class RabbitMessageDTO {
    private Type type;
    String content;
}
