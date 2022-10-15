package liga.common.ligaconsumer.Config;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private static final String HOST = "localhost";
    public static final String QUEUE_DAILY = "daily_queue";
    public static final String QUEUE_ALLERT = "alert_queue";
    public static final String QUEUE_ERROR = "error_queue";

    @Bean
    public ConnectionFactory connectionFactory(){
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public AmqpAdmin amqpAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public  RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue getDailyQueue(){
        return new Queue(QUEUE_DAILY);
    }
    @Bean
    public Queue getAlertQueue(){
        return new Queue(QUEUE_ALLERT);
    }
    @Bean
    public Queue getErrorQueue(){
        return new Queue(QUEUE_ERROR);
    }
}
