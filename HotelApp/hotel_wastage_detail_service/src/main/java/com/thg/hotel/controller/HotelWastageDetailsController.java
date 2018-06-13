package com.thg.hotel.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thg.hotel.domain.HotelWastageDetails;
import com.thg.hotel.domain.HotelWastageDetailsId;
import com.thg.hotel.enums.WastageType;
import com.thg.hotel.service.HotelWastageDetailsService;
import com.thg.hotel.utils.DateUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HotelWastageDetailsController {

  private final HotelWastageDetailsService hotelWastageDetailsService;

  @GetMapping(value = "/hotels/wastagedetails/{hotelid}/{wastage_type}/{date}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public HotelWastageDetails getHotelWastageDetails(@PathVariable("hotelid") Integer hotelId,
      @PathVariable("wastage_type") WastageType wastageType, @PathVariable("date") String wastageByMonth)
      throws Exception {
    Date date = DateUtil.getDate(wastageByMonth, "HotelWastageDetailsController");
    HotelWastageDetails hotelWastageDetails =
        hotelWastageDetailsService
            .getHotelWastageDetails(
                HotelWastageDetailsId.builder().date(date).hotelId(hotelId).wastageType(wastageType).build())
            .get();
    return hotelWastageDetails;
  }

  @PostMapping(value = "/hotels/wastagedetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public void createHotelWastageDetails(@RequestBody HotelWastageDetails hotelWastageDetails) throws Exception {
    hotelWastageDetailsService.createHotelWastageDetails(hotelWastageDetails);
  }

  @GetMapping(value = "/hotels/wastagedetails/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<HotelWastageDetails> getHotelWastageDetailsByHotel(
      @RequestParam(name = "hotelid") Integer hotelId,
      @RequestParam(name="wastageType",required=false) WastageType wastageType,
      @RequestParam(name = "wastageByMonth", required = false) Date wastageByMonth) throws Exception {
    List<HotelWastageDetails> hotelsWastageDetails = null;
    if (Objects.nonNull(hotelId) && Objects.nonNull(wastageType)) {
      hotelsWastageDetails =
          hotelWastageDetailsService.getHotelWastageDetailsByHotelAndWastageType(hotelId, wastageType);
    }else if (Objects.nonNull(hotelId) && Objects.nonNull(wastageByMonth)) {
      hotelsWastageDetails =
          hotelWastageDetailsService.getHotelWastageDetailsByHotelAndWastageMonth(hotelId, wastageByMonth);
    } else {
      hotelsWastageDetails = hotelWastageDetailsService.getHotelWastageDetailsByHotel(hotelId);
    } 
    return hotelsWastageDetails;

  }



}
