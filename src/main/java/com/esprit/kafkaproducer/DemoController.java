package com.esprit.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

@Autowired
    KafkaTemplate<String,Book> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

   @PostMapping("/publish")
    public String publishMessag(@RequestBody Book book)
   {

        kafkaTemplate.send(TOPIC,book);
        return "Published Successfully!";

    }
}
