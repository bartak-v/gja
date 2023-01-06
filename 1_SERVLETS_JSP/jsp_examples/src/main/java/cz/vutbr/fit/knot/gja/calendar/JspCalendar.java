/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * File: JspCalendar.java
 * Description: Calendar backbean
 */

/**
 * @file JspCalendar.java
 *
 * @brief Calendar backbean
 */

package cz.vutbr.fit.knot.gja.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar backbean
 * 
 * @brief Calendar backbean
 */
public class JspCalendar {

  /** Calendar object */
  private Calendar calendar = null;

  /**
   * Constructor
   */
  public JspCalendar() {
    calendar = Calendar.getInstance();
    Date currentTime = new Date();
    calendar.setTime(currentTime);
  }

  /**
   * Gets year
   * 
   * @return Returns year
   */
  public int getYear() {
    return calendar.get(Calendar.YEAR);
  }

  /**
   * Gets month
   * 
   * @return Returns month (word)
   */
  public String getMonth() {
    int m = getMonthInt();
    String[] months = new String[]{"January", "February", "March",
                                   "April", "May", "June",
                                   "July", "August", "September",
                                   "October", "November", "December"};
    if (m > 12) {  // wrong month
      return "Unknown to Man";
    }
    return months[m - 1];
  }

  /**
   * Gets day
   * 
   * @return Returns day (word)
   */
  public String getDay() {
    int x = getDayOfWeek();
    String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday",
                                 "Thursday", "Friday", "Saturday"};
    if (x > 7) {  // wrong day
      return "Unknown to Man";
    }
    return days[x - 1];
  }

  /**
   * Gets month number
   * 
   * @return Returns month number
   */
  public int getMonthInt() {
    return 1 + calendar.get(Calendar.MONTH);
  }

  /**
   * Gets formatted date
   * 
   * @return Returns formatted date
   */
  public String getDate() {
    return getMonthInt() + "/" + getDayOfMonth() + "/" + getYear();
  }

  /**
   * Gets current date
   * 
   * @return Returns current formatted date
   */
  public String getCurrentDate() {
    Date dt = new Date();
    calendar.setTime(dt);
    return getMonthInt() + "/" + getDayOfMonth() + "/" + getYear();

  }

  /**
   * Sets calendar to next date and returns it
   * 
   * @return Returns next date
   */
  public String getNextDate() {
    calendar.set(Calendar.DAY_OF_MONTH, getDayOfMonth() + 1);
    return getDate();
  }

  /**
   * Sets calendar to previous date and returns it
   * 
   * @return Returns previous date
   */
  public String getPrevDate() {
    calendar.set(Calendar.DAY_OF_MONTH, getDayOfMonth() - 1);
    return getDate();
  }

  /**
   * Gets formatted time
   * 
   * @return Returns formatted time
   */
  public String getTime() {
    return getHour() + ":" + getMinute() + ":" + getSecond();
  }

  /**
   * Gets number of day of month
   * 
   * @return Returns number of day of month
   */
  public int getDayOfMonth() {
    return calendar.get(Calendar.DAY_OF_MONTH);
  }

  /**
   * Gets number of day in year
   * 
   * @return Gets number of day in year
   */
  public int getDayOfYear() {
    return calendar.get(Calendar.DAY_OF_YEAR);
  }

  /**
   * Gets number of week in year
   * 
   * @return Gets number of week in year
   */
  public int getWeekOfYear() {
    return calendar.get(Calendar.WEEK_OF_YEAR);
  }

  /**
   * Gets number of week in month
   * 
   * @return Gets number of week in month
   */
  public int getWeekOfMonth() {
    return calendar.get(Calendar.WEEK_OF_MONTH);
  }

  /**
   * Gets number of day in week
   * 
   * @return Gets number of day in week
   */
  public int getDayOfWeek() {
    return calendar.get(Calendar.DAY_OF_WEEK);
  }

  /**
   * Gets hour
   * 
   * @return Returns hour
   */
  public int getHour() {
    return calendar.get(Calendar.HOUR_OF_DAY);
  }

  /**
   * Gets minute
   * 
   * @return Returns minute
   */
  public int getMinute() {
    return calendar.get(Calendar.MINUTE);
  }

  /**
   * Gets second
   * 
   * @return Returns second
   */
  public int getSecond() {
    return calendar.get(Calendar.SECOND);
  }

  /**
   * Gets era
   * 
   * @return Returns era
   */
  public int getEra() {
    return calendar.get(Calendar.ERA);
  }

  /**
   * Gets US time zone
   * 
   * @return Returns US time zone
   */
  public String getUSTimeZone() {
    String[] zones = new String[]{"Hawaii", "Alaskan", "Pacific",
                                  "Mountain", "Central", "Eastern"};

    return zones[10 + getZoneOffset()];
  }

  /**
   * Gets time zone offset
   * 
   * @return Returns time zone offset in hours
   */
  public int getZoneOffset() {
    return calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000);
  }

  /**
   * Gets daylight saving time offset
   * 
   * @return Returns daylight saving time offset
   */
  public int getDSTOffset() {
    return calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000);
  }

  /**
   * Gets AM or PM
   * 
   * @return Returns AM or PM
   */
  public int getAMPM() {
    return calendar.get(Calendar.AM_PM);
  }
}  // public class JspCalendar
