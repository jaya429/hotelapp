package com.thg.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thg.hotel.domain.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer>{

}
