package com.thg.hotel.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thg.hotel.domain.HotelWastageDetails;
import com.thg.hotel.domain.HotelWastageDetailsId;
import com.thg.hotel.enums.WastageType;

@Service
public interface HotelWastageDetailsService {

  public void createHotelWastageDetails(HotelWastageDetails hotelWastageDetails) throws Exception;

  public Optional<HotelWastageDetails> getHotelWastageDetails(HotelWastageDetailsId id) throws Exception;

  public List<HotelWastageDetails> getHotelWastageDetailsByHotel(Integer hotelId) throws Exception;

  public List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageType(Integer hotelId, WastageType wastageType)
      throws Exception;

  List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageMonth(Integer hotelId, Date wastageByMonth)
      throws Exception;


}
