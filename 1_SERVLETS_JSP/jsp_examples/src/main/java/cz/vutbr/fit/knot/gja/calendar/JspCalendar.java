/*
 * Project: Examples for GJA course
 * Author: Ing. Jaroslav Dytrych idytrych@fit.vutbr.cz
 * Refactored: Bc. Vít Barták xbarta47@stud.fit.vutbr.cz
 * File: JspCalendar.java
 * Description: Calendar backbean
 */
/**
 * @file JspCalendar.java
 *
 * Calendar backbean
 */
package cz.vutbr.fit.knot.gja.calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar backbean
 */
public class JspCalendar {

    /**
     * Calendar object
     */
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
     * @return Year
     */
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Gets month
     *
     * @return Month (word)
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
     * @return Day (as a word)
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
     * @return Month number
     */
    public int getMonthInt() {
        return 1 + calendar.get(Calendar.MONTH);
    }

    /**
     * Gets formatted date
     *
     * @return Formatted date
     */
    public String getDate() {
        return getMonthInt() + "/" + getDayOfMonth() + "/" + getYear();
    }

    /**
     * Gets current date
     *
     * @return Current formatted date
     */
    public String getCurrentDate() {
        Date dt = new Date();
        calendar.setTime(dt);
        return getMonthInt() + "/" + getDayOfMonth() + "/" + getYear();

    }

    /**
     * Sets calendar to next date and returns it
     *
     * @return Next date
     */
    public String getNextDate() {
        calendar.set(Calendar.DAY_OF_MONTH, getDayOfMonth() + 1);
        return getDate();
    }

    /**
     * Sets calendar to previous date and returns it
     *
     * @return Previous date
     */
    public String getPrevDate() {
        calendar.set(Calendar.DAY_OF_MONTH, getDayOfMonth() - 1);
        return getDate();
    }

    /**
     * Gets formatted time
     *
     * @return Formatted time
     */
    public String getTime() {
        return getHour() + ":" + getMinute() + ":" + getSecond();
    }

    /**
     * Gets number of day of month
     *
     * @return Number of day of month
     */
    public int getDayOfMonth() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Gets number of day in year
     *
     * @return Number of day in a year
     */
    public int getDayOfYear() {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Gets number of week in year
     *
     * @return Number of week in year
     */
    public int getWeekOfYear() {
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Gets number of week in month
     *
     * @return Number of week in month
     */
    public int getWeekOfMonth() {
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * Gets number of day in week
     *
     * @return Number of day in week
     */
    public int getDayOfWeek() {
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Gets hour
     *
     * @return Hour
     */
    public int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Gets minute
     *
     * @return Minute
     */
    public int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * Gets second
     *
     * @return Second
     */
    public int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * Gets era
     *
     * @return Era
     */
    public int getEra() {
        return calendar.get(Calendar.ERA);
    }

    /**
     * Gets US time zone
     *
     * @return US time zone
     */
    public String getUSTimeZone() {
        String[] zones = new String[]{"Hawaii", "Alaskan", "Pacific",
            "Mountain", "Central", "Eastern"};

        return zones[10 + getZoneOffset()];
    }

    /**
     * Gets time zone offset
     *
     * @return Time zone offset in hours
     */
    public int getZoneOffset() {
        return calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000);
    }

    /**
     * Gets daylight saving time offset
     *
     * @return Daylight saving time offset
     */
    public int getDSTOffset() {
        return calendar.get(Calendar.DST_OFFSET) / (60 * 60 * 1000);
    }

    /**
     * Gets AM or PM
     *
     * @return AM or PM
     */
    public int getAMPM() {
        return calendar.get(Calendar.AM_PM);
    }
}  // public class JspCalendar
