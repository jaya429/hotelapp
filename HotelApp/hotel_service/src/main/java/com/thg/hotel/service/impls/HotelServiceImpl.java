package com.thg.hotel.service.impls;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thg.hotel.domain.Hotel;
import com.thg.hotel.repository.HotelRepository;
import com.thg.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelServiceImpl implements HotelService{

  private final  HotelRepository hotelRepository;

  @Override
  public void createHotel(Hotel hotel) throws Exception {
    hotelRepository.save(hotel); 
  }

  @Override
  public void deleteHotel(Hotel hotel) throws Exception {
    hotelRepository.delete(hotel);    
  }

  @Override
  public Optional<Hotel> getHotel(Integer hotelId) throws Exception {
    return hotelRepository.findById(hotelId);
  }
  
  
}
