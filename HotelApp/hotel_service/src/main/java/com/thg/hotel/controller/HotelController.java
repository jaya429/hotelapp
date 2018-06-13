package com.thg.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thg.hotel.domain.Hotel;
import com.thg.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelController {

  private final HotelService hotelService;

  @GetMapping(value = "/hotels/{hotelid}",produces = MediaType.APPLICATION_JSON_VALUE)
  public Hotel getHotel(@PathVariable("hotelid") Integer hotelId) throws Exception {
    Hotel hotel = hotelService.getHotel(hotelId).orElse(new Hotel());
    return hotel;
  }

  @PostMapping(value = "/hotels",consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public void createHotel(@RequestBody Hotel hotel) throws Exception {
    hotelService.createHotel(hotel);
  }

  @DeleteMapping(value = "/hotels",consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deleteHotel(@RequestBody Hotel hotel) throws Exception {
    hotelService.deleteHotel(hotel);
  }


}
