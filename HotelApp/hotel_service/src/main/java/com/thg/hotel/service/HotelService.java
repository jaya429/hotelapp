package com.thg.hotel.service;

import java.util.Optional;

import com.thg.hotel.domain.Hotel;

public interface HotelService {

  public void createHotel(Hotel hotel)throws Exception;
  
  public void deleteHotel(Hotel hotel)throws Exception;
  
  public Optional<Hotel> getHotel(Integer hotelId)throws Exception;
}
