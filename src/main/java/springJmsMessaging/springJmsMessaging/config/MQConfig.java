package springJmsMessaging.springJmsMessaging.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;


@Configuration
@EnableJms
public class MQConfig {

     @Value("${mqUrl}")
     private String mqUrl;


   // creating the queue form activeMQ
    @Bean
    public Queue getQueue(){
        return  new ActiveMQQueue("myQueue");
    }

    // creating the connection
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() throws JMSException {
        ActiveMQConnectionFactory connection = new ActiveMQConnectionFactory();
        connection.setBrokerURL(mqUrl);
        return connection;
    }

     // creating the jms  template
    @Bean
    JmsTemplate jmsTemplate() throws JMSException {
        return new JmsTemplate(activeMQConnectionFactory());
    }


    //we create a message converter
    @Bean
    MessageConverter messageConverter(){
    return new SimpleMessageConverter();
    }
}
