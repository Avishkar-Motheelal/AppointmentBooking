package com.example.bookingprocessor.services;

import com.example.bookingprocessor.model.BookingModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    @KafkaListener(topics = "booking-processor-topic", groupId = "booking-api")
    public void consume(BookingModel message) {
        System.out.println("Consumed message: " + message.toString());
        // Process the message here
    }
}
