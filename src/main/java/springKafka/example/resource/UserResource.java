package springKafka.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springKafka.example.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC,new User(name,"Technology",12000L));
        return "Published successfully";
    }
}

//@RestController
//@RequestMapping("kafka")
//public class UserResource{
//
//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;
//
//    private static final String TOPIC = "Kafka_Example";
//
//    @GetMapping("/pub/{message}")
//    public String post(@PathVariable("message") final String message){
//
//        kafkaTemplate.send(TOPIC,message);
//
//        return "Published successfully";
//    }
//}
