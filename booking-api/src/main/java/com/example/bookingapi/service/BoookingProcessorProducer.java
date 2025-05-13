package com.example.bookingapi.service;

import com.example.bookingapi.model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BoookingProcessorProducer {
    private static final String TOPIC_NAME = "booking-processor-topic";
    @Autowired
    private KafkaTemplate<String, BookingModel> kafkaTemplate;


    public void sendBookingMessage(BookingModel bookingModel) {
        kafkaTemplate.send(TOPIC_NAME, bookingModel);
    }
}
