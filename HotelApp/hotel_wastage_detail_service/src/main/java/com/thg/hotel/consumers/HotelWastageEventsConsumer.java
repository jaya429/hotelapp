package com.thg.hotel.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thg.hotel.domain.HotelWastageDetails;
import com.thg.hotel.service.HotelWastageDetailsService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelWastageEventsConsumer {

  private final HotelWastageDetailsService hotelWastageDetailsService;

  
  @KafkaListener (topics = "${kafka.topic:hotel_wastage_details}")
  public void receive(@Payload String message) throws Exception {
    
    ObjectMapper mapper = new ObjectMapper();
    HotelWastageDetails hotelWastageDetails = mapper.readValue(message, HotelWastageDetails.class);
    hotelWastageDetailsService.createHotelWastageDetails(hotelWastageDetails);
  }
}
