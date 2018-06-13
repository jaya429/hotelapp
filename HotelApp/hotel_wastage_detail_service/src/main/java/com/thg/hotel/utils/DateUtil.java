package com.thg.hotel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings("STCAL_INVOKE_ON_STATIC_DATE_FORMAT_INSTANCE")
public class DateUtil {
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public static String formatDate(Date date) {
    return dateFormat.format(date);
  }

  public static Date getDate(String dateStr, String resource) throws Exception {
    return dateFormat.parse(dateStr);
  }

}
