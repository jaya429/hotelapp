package com.thg.hotel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thg.hotel.domain.HotelWastageDetails;
import com.thg.hotel.domain.HotelWastageDetailsId;
import com.thg.hotel.enums.WastageType;

@Repository
public interface HotelWastageDetailsRepository extends CrudRepository<HotelWastageDetails, HotelWastageDetailsId>{

  @Query("SELECT hotelWastageDetails FROM HotelWastageDetails hotelWastageDetails WHERE hotelWastageDetails.id.hotelId = :hotelId")
  List<HotelWastageDetails> getHotelWastageDetailsByHotel(@Param("hotelId") Integer hotelId);
  
  @Query("SELECT hotelWastageDetails FROM HotelWastageDetails hotelWastageDetails WHERE hotelWastageDetails.id.hotelId = :hotelId and hotelWastageDetails.id.wastageType =:wastageType")
  List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageType(@Param("hotelId") Integer hotelId,@Param("wastageType") WastageType wastageType);
  
  
  @Query("SELECT hotelWastageDetails FROM HotelWastageDetails hotelWastageDetails WHERE  hotelWastageDetails.id.hotelId = :hotelId and hotelWastageDetails.id.date =:wastageByMonth")
  List<HotelWastageDetails> getHotelWastageDetailsByHotelAndWastageMonth(@Param("hotelId") Integer hotelId,@Param("wastageByMonth") Date wastageByMonth);
}
