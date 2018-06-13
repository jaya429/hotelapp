package com.thg.hotel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1927208748634781374L;
  @Column(name="htl_addrs")
  private String address;
  @Column(name="htl_city_name")
  private String cityName;
  @Column(name="htl_sate_name")
  private String State;
  @Column(name="htl_cntry_name")
  private String country;
}
