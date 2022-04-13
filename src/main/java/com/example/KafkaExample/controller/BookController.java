package com.example.KafkaExample.controller;

import com.example.KafkaExample.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;
    private static final String TOPIC = "NewTopic";
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        kafkaTemplate.send(TOPIC,book);
        return "Published Successfully";
    }
}
