package com.thg.hotel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.thg.hotel.enums.WastageType;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuppressFBWarnings({"EI_EXPOSE_REP","EI_EXPOSE_REP2"})
public class HotelWastageDetailsId implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -9160423064984957267L;
  @Column(name="htl_id")
  private Integer hotelId;
  @Column(name="htl_wstg_type")
  private WastageType wastageType;
  @Temporal(TemporalType.DATE)
  @Column(name="htl_wstg_by_mnth")
  private Date date;
}
