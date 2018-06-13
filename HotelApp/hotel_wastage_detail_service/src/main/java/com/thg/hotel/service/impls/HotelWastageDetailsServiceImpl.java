package com.thg.hotel.service.impls;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thg.hotel.domain.HotelWastageDetails;
import com.thg.hotel.domain.HotelWastageDetailsId;
import com.thg.hotel.enums.WastageType;
import com.thg.hotel.repository.HotelWastageDetailsRepository;
import com.thg.hotel.service.HotelWastageDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelWastageDetailsServiceImpl implements  HotelWastageDetailsService{
  
  private final HotelWastageDetailsRepository hotelWastageDetailsRepository;

  @Override
  public void createHotelWastageDetails(HotelWastageDetails hotelWastageDetails) throws Exception {
      hotelWastageDetailsRepository.save(hotelWastageDetails);    
  }
  
  @Override
  public Optional<HotelWastageDetails> getHotelWastageDetails(HotelWastageDetailsId id) throws Exception {
    return hotelWastageDetailsRepository.findById(id);
  }

  @Override
  public List<HotelWastageDetails> getHotelWastageDetailsByHotel(Integer hotelId) throws Exception {
    return hotelWastageDetailsRepository.getHotelWastageDetailsByHotel(hotelId);
  }

  @Override
  public List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageType(Integer hotelId, WastageType wastageType)
      throws Exception {
    return hotelWastageDetailsRepository.getHotelWastageDetailsByHotelAndWastageType(hotelId, wastageType);
  }

  @Override
  public List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageMonth(Integer hotelId, Date wastageByMonth)
      throws Exception {
    return hotelWastageDetailsRepository.getHotelWastageDetailsByHotelAndWastageMonth(hotelId, wastageByMonth);
  }

}
