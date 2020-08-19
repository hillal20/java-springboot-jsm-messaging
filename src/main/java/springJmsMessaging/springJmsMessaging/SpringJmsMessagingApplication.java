package springJmsMessaging.springJmsMessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJmsMessagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJmsMessagingApplication.class, args);
        System.out.println("== active mq is running ====");
    }

}
