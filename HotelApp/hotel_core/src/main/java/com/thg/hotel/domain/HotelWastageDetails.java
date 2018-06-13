package com.thg.hotel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thg.hotel.enums.HotelWastageAttributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tgh_htl_wstg_dtl",schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelWastageDetails implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 7757304758869115199L;
  @EmbeddedId
  private HotelWastageDetailsId id;
  @Column(name="htl_wstg_attr")
  private HotelWastageAttributes hotelWastageAttributes;
  @Column(name="htl_wstg_unts")
  private Integer units;
  
}
