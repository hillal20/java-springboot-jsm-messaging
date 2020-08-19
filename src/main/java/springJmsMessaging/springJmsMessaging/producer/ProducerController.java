package springJmsMessaging.springJmsMessaging.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerController {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue myQueue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") String message){

        jmsTemplate.convertAndSend(myQueue, message);
        return "published successful";
    }

}
